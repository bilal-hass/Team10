package Discount;

import DB.DBConnWrapper;
import Processing.Job;

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
	private ArrayList<FlexibleJobAmount> _jobDiscounts;
	public FlexibleDiscount(Integer customerId, Integer id, String name, String description) {
		super(customerId, id, name, description, DiscountTypes.FLEXIBLE);

		_jobDiscounts = new ArrayList<FlexibleJobAmount>();
		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT FJA.StartPrice, FJA.EndPrice, FJA.Amount, FD.`JobType` FROM CustomerAccount AS C \n" +
				"INNER JOIN DiscountPlan AS DP ON C.DiscountPlan = DP.id\n" +
				"INNER JOIN FlexibleDiscount AS FD ON DP.FlexibleDiscount = FD.id\n" +
				"INNER JOIN FlexibleJobAmounts AS FJA ON FJA.FlexibleDiscount = FD.id\n" +
				"WHERE C.No = " + customerId +  ";";
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

	@Override
	public Float getPrice(Job job) {
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
		return price * (1 - amount);
	}
}