package Discount;

import DB.DBConnWrapper;
import Processing.Job;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

class FlexibleJobAmount {
	public Float _startPrice, _endPrice, _amount;
	public Integer _jobType;

	public FlexibleJobAmount(Float startPrice, Float endPrice, Float amount, Integer jobType) {
		_startPrice = startPrice;
		_endPrice = endPrice;
		_amount = amount;
		_jobType = jobType;
	}
}

public class FlexibleDiscount extends Discount {
	private Integer _discountPlanId;
	private Integer _FlexibleDiscountId;
	private ArrayList<FlexibleJobAmount> _jobDiscounts;
	public FlexibleDiscount(Integer id, String name, String description) {
		super(id, name, description, DiscountTypes.FLEXIBLE);

		_jobDiscounts = new ArrayList<FlexibleJobAmount>();
		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT FD.id FROM DiscountPlan AS DP\n" +
				"INNER JOIN FlexibleDiscount AS FD ON DP.FlexibleDiscount = FD.id\n" +
				"WHERE DP.id = " + id +  ";";
		try {
			ResultSet RS = conn.createStatement().executeQuery(query);
			while (RS.next()) {
				_FlexibleDiscountId = RS.getInt("id");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		UpdateFlexibleRates();
	}

	public void UpdateFlexibleRates() {
		_jobDiscounts = new ArrayList<FlexibleJobAmount>();

		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT FJA.StartPrice, FJA.EndPrice, FJA.Amount, FJA.JobType FROM DiscountPlan AS DP\n" +
				"INNER JOIN FlexibleDiscount AS FD ON DP.FlexibleDiscount = FD.id\n" +
				"INNER JOIN FlexibleJobAmounts AS FJA ON FJA.FlexibleDiscount = FD.id\n" +
				"WHERE DP.id = " + getId() +  ";";
		try {
			ResultSet RS = conn.createStatement().executeQuery(query);
			while (RS.next()) {
				Float StartPrice = RS.getFloat("StartPrice");
				Float EndPrice = RS.getFloat("EndPrice");
				Float Amount = RS.getFloat("Amount");
				Integer JobType = RS.getInt("JobType");
				_jobDiscounts.add(new FlexibleJobAmount(StartPrice, EndPrice, Amount, JobType));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Integer getFlexibleDiscountId() {
		return _FlexibleDiscountId;
	}

	public Float getFlexiblePrice(Job job) {
		Integer jobType = job.getType();
		Float price = job.getPriceBeforeDiscount();
		Float amount = 0f;
		for (FlexibleJobAmount FJA: _jobDiscounts) {
			if (FJA._jobType.equals(job.getType())) {
				if (price > FJA._startPrice && price <= FJA._endPrice) {
					amount = FJA._amount;
				}
			}
		}
		return price * (1 - amount) * 1.2f;
	}

	public void deleteFlexible() {
		String query = "DELETE FROM FlexibleDiscount WHERE id = " + _FlexibleDiscountId.toString();
		Connection conn = DBConnWrapper.getConnection();
		try {
			conn.createStatement().executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}