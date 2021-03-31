package Discount;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Processing.Job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscountController {
	private static void ExecuteTrivialQuery(String query) {
		Connection conn = DBConnWrapper.getConnection();
		try {
			conn.createStatement().executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//tested & works
	public static FixedDiscount createFixedDiscountPlan(String _name, String _description, Float _amount) {
		String query = "INSERT INTO DiscountPlan(`Name`, `Description`, `Type`, `VariableDiscount`, `FlexibleDiscount`, `FlatDiscount`) VALUES\n"
				+ "('"+_name+"', '" + _description + "', 'FIXED', NULL, NULL, " + _amount.toString() + ");";
		ExecuteTrivialQuery(query);

		Integer Id = DBConnWrapper.getMaxId("DiscountPlan");
		return new FixedDiscount(Id, _name, _description);
	}

	//tested & works
	public static Discount createVariableDiscountPlan(String _name, String _description, ArrayList<TaskPercentPair> _rates) {

		ExecuteTrivialQuery("INSERT INTO VariableDiscount() VALUES ()");
		Integer VariableDiscount_id = DBConnWrapper.getMaxId("VariableDiscount");

		ExecuteTrivialQuery("INSERT INTO DiscountPlan(`Name`, `Description`, `Type`, `VariableDiscount`, `FlexibleDiscount`, `FlatDiscount`) VALUES\n"
				+ "('"+_name+"', '" + _description + "', 'VARIABLE', "+VariableDiscount_id.toString()+", NULL, 0);");
		Integer DiscountPlan_id = DBConnWrapper.getMaxId("DiscountPlan");

		VariableDiscount d = new VariableDiscount(DiscountPlan_id, _name, _description);
		addVariableRates(d, _rates);

		return d;
	}

	//tested & works
	public static void addVariableRates(VariableDiscount d, ArrayList<TaskPercentPair> _rates) {
		StringBuilder SQLRatesBuilder = new StringBuilder();
		for (TaskPercentPair TPP: _rates) {
			SQLRatesBuilder.append("\n\t(").append(TPP.Amount.toString()).append(", ").append(d.getVariableDiscountId().toString()).append(", ").append(TPP.TaskType.toString()).append("),");
		}
		String SQLRates = SQLRatesBuilder.toString();
		ExecuteTrivialQuery("INSERT INTO VariableTaskAmounts(`Amount`, `VariableDiscount`, `TaskType`) VALUES" + SQLRates.substring(1, SQLRates.length()-1) +  ";");
		d.UpdateDiscountValues();
	}

	//tested & works
	public static Discount createFlexibleDiscountPlan(String _name, String _description, ArrayList<JobFlexibleData> _rates) {
		ExecuteTrivialQuery("INSERT INTO FlexibleDiscount() VALUES ()");
		Integer FlexibleDiscount_Id = DBConnWrapper.getMaxId("FlexibleDiscount");



		ExecuteTrivialQuery("INSERT INTO DiscountPlan(`Name`, `Description`, `Type`, `VariableDiscount`, `FlexibleDiscount`, `FlatDiscount`) VALUES\n"
				+ "('"+_name+"', '" + _description + "', 'VARIABLE', NULL, " + FlexibleDiscount_Id.toString() + ", 0);");
		Integer DiscountPlan_Id = DBConnWrapper.getMaxId("DiscountPlan");

		FlexibleDiscount d = new FlexibleDiscount(DiscountPlan_Id, _name, _description);
		addFlexibleRates(d, _rates);
		return d;
	}

	//tested & works
	public static void addFlexibleRates(FlexibleDiscount d, ArrayList<JobFlexibleData> _rates) {
		ExecuteTrivialQuery("SET FOREIGN_KEY_CHECKS=0;");
		//necessary for some reason... works in mysql but not jdbc unless I have this.

		StringBuilder SQLRates = new StringBuilder();
		for (JobFlexibleData FJA: _rates) {
			SQLRates.append("\n(").append(FJA.StartPrice.toString()).append(", ").append(FJA.EndPrice.toString()).append(", ").append(FJA.Amount.toString()).append(", ").append(d.getFlexibleDiscountId().toString()).append(",").append(FJA.JobType.toString()).append("),");
		}
		String query = SQLRates.toString();
		query = query.substring(1, query.length()-1);

		ExecuteTrivialQuery("INSERT INTO FlexibleJobAmounts(`StartPrice`, `EndPrice`, `Amount`, `FlexibleDiscount`, `JobType`) VALUES" + query + ";");

		ExecuteTrivialQuery("SET FOREIGN_KEY_CHECKS=1;");
	}

	public static Discount getDiscountById(Integer id) {
		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT DP.`id`, DP.`Name`, DP.`Description`, DP.`Type` FROM DiscountPlan AS DP \n"
				+ "WHERE DP.`id` = " + id.toString() + ";";

		Discount discount;

		String name = "";
		String description = "";
		String type = "";

		try {
			ResultSet RS = conn.createStatement().executeQuery(query);
			while (RS.next()) {
				id = RS.getInt("id");
				name = RS.getString("Name");
				description = RS.getString("Description");
				type = RS.getString("Type");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		discount = new Discount(id, name, description, Discount.DiscountTypes.FIXED);

		if (id != 0) {
			switch (type) {
				case "FIXED":
					return new FixedDiscount(id, name, description);

				case "FLEXIBLE":
					return new FlexibleDiscount(id, name, type);

				case "VARIABLE":
					return new VariableDiscount(id, name, type);
			}
		}

		return discount;
	}

	public static Discount getDiscount(CustomerAccount customer) {

		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT DP.`id`, DP.`Name`, DP.`Description`, DP.`Type` FROM CustomerAccount AS C\n"
				+ "INNER JOIN DiscountPlan AS DP ON DP.id = C.DiscountPlan\n"
				+ "WHERE C.No = " + customer.getId().toString() + ";";

		Discount discount;
		int id = 0;

		try {
			ResultSet RS = conn.createStatement().executeQuery(query);
			while (RS.next()) {
				id = RS.getInt("id");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return getDiscountById(id);
	}

	public static Float getPrice(Job j) {
		CustomerAccount customer = j.getCustomer();
		Discount d = getDiscount(customer);

		if (d.getType() == Discount.DiscountTypes.FIXED) {
			FixedDiscount f = (FixedDiscount)d;
			return f.getPrice(j);
		}
		else if(d.getType() == Discount.DiscountTypes.FLEXIBLE) {
			FlexibleDiscount f = (FlexibleDiscount)d;
			return f.getPrice(j);
		}
		else if(d.getType() == Discount.DiscountTypes.VARIABLE) {
			VariableDiscount v = (VariableDiscount)d;
			return v.getVariablePrice(j);
		}
		return j.getPriceBeforeDiscount();
	}
}