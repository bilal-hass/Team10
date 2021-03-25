package Discount;

import DB.DBConnWrapper;
import Processing.Job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FixedDiscount extends Discount {
	private Integer _discountPlanId;
	private Float _percentage;

	FixedDiscount(Integer id, String name, String description) {
		super(id, name, description, DiscountTypes.FIXED);
		_discountPlanId = id;

		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT DP.`FlatDiscount` FROM DiscountPlan AS DP WHERE DP.`id` = " + id.toString() + ";";
		try {
			ResultSet RS = conn.createStatement().executeQuery(query);
			while (RS.next()) {
				_percentage = RS.getFloat("FlatDiscount");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public float getPercentage() {
		return _percentage;
	}
	@Override
	public Float getPrice(Job job) {
		Float price = job.getPriceBeforeDiscount();
		return price * (1.f - _percentage);
	}
}