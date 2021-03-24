package Discount;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Processing.Job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscountController {
	private static Integer getMaxId(String table) {
		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT MAX(id) FROM " + table + ";";
		try {
			ResultSet RS = conn.createStatement().executeQuery(query);
			if (RS.next()) {
				return RS.getInt("MAX(id)");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

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
	public static void createFlatDiscountPlan(String _name, String _description, Float _amount) {
		String query = "INSERT INTO DiscountPlan(`Name`, `Description`, `Type`, `VariableDiscount`, `FlexibleDiscount`, `FlatDiscount`) VALUES\n"
				+ "('"+_name+"', '" + _description + "', 'FIXED', NULL, NULL, " + _amount.toString() + ");";
		ExecuteTrivialQuery(query);
	}

	//tested & works
	public static void createVariableDiscountPlan(String _name, String _description, ArrayList<TaskPercentPair> _rates) {

		ExecuteTrivialQuery("INSERT INTO VariableDiscount() VALUES ()");
		Integer Id = getMaxId("VariableDiscount");

		StringBuilder SQLRatesBuilder = new StringBuilder();
		for (TaskPercentPair TPP: _rates) {
			SQLRatesBuilder.append("\n\t(").append(TPP.Amount.toString()).append(", ").append(Id.toString()).append(", ").append(TPP.TaskType.toString()).append("),");
		}
		String SQLRates = SQLRatesBuilder.toString();

		ExecuteTrivialQuery("INSERT INTO VariableTaskAmounts(`Amount`, `VariableDiscount`, `TaskType`) VALUES" + SQLRates.substring(1, SQLRates.length()-1) +  ";");

		ExecuteTrivialQuery("INSERT INTO DiscountPlan(`Name`, `Description`, `Type`, `VariableDiscount`, `FlexibleDiscount`, `FlatDiscount`) VALUES\n"
				+ "('"+_name+"', '" + _description + "', 'VARIABLE', "+Id.toString()+", NULL, 0);");
	}

	//tested & works
	public static void createFlexibleDiscountPlan(String _name, String _description, ArrayList<JobFlexibleData> _rates) {
		ExecuteTrivialQuery("INSERT INTO FlexibleDiscount() VALUES ()");
		Integer Id = getMaxId("FlexibleDiscount");

		ExecuteTrivialQuery("SET FOREIGN_KEY_CHECKS=0;");
		//necessary due to bug with jdbc being retarded idk....

		StringBuilder SQLRates = new StringBuilder();
		for (JobFlexibleData FJA: _rates) {
			SQLRates.append("\n(").append(FJA.StartPrice.toString()).append(", ").append(FJA.EndPrice.toString()).append(", ").append(FJA.Amount.toString()).append(", ").append(Id.toString()).append(",").append(FJA.JobType.toString()).append("),");
		}
		String query = SQLRates.toString();
		query = query.substring(1, query.length()-1);

		ExecuteTrivialQuery("INSERT INTO FlexibleJobAmounts(`StartPrice`, `EndPrice`, `Amount`, `FlexibleDiscount`, `JobType`) VALUES" + query + ";");

		ExecuteTrivialQuery("INSERT INTO DiscountPlan(`Name`, `Description`, `Type`, `VariableDiscount`, `FlexibleDiscount`, `FlatDiscount`) VALUES\n"
				+ "('"+_name+"', '" + _description + "', 'VARIABLE', NULL, " + Id.toString() + ", 0);");

		ExecuteTrivialQuery("SET FOREIGN_KEY_CHECKS=1;");
	}

	public static Discount getDiscount(CustomerAccount customer) {

		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT DP.`id`, DP.`Name`, DP.`Description`, DP.`Type` FROM CustomerAccount AS C\n"
				+ "INNER JOIN DiscountPlan AS DP ON DP.id = C.DiscountPlan\n"
				+ "WHERE C.No = " + customer.getId().toString() + ";";

		Discount discount;
		int id = 0;
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

		discount = new Discount(customer.getId(), id, name, description, Discount.DiscountTypes.FIXED);

		if (id != 0) {
			switch (type) {
				case "FIXED":
					return new FixedDiscount(customer.getId(), id, name, description);
				case "FLEXIBLE":
					return new FlexibleDiscount(customer.getId(), id, name, type);
				case "VARIABLE":
					return new VariableDiscount(customer.getId(), id, name, type);
			}
		}

		return discount;
	}

	public static Float getPrice(Job j) {
		CustomerAccount customer = j.getCustomer();
		Discount d = getDiscount(customer);
		System.out.println(d.getType());

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