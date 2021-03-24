package Discount;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DB.DBConnWrapper;
import Processing.Job;
import Processing.Task;

public class VariableDiscount extends Discount {
	private Map<Integer, Float> _discountMap = new HashMap<Integer, Float>(); //TaskType -> Percentage
	private Integer _id;

	public VariableDiscount(Integer customerId, Integer id, String name, String description) {
		super(customerId, id, name, description, DiscountTypes.VARIABLE);

		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT VTA.Amount, VTA.TaskType FROM DiscountPlan AS DP\n" +
				"INNER JOIN VariableDiscount AS VD ON VD.id = DP.VariableDiscount\n" +
				"INNER JOIN VariableTaskAmounts AS VTA ON VTA.VariableDiscount = VD.id\n" +
				"INNER JOIN Task AS T ON T.TaskType = VTA.TaskType\n" +
				"WHERE DP.id = " + id.toString() + ";";
		try {
			ResultSet RS = conn.createStatement().executeQuery(query);
			while (RS.next()) {
				Float Percentage = RS.getFloat("Amount");
				Integer TaskType = RS.getInt("TaskType");
				_discountMap.put(TaskType, Percentage);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Float getVariablePrice(Job job) {
		//applies the per task discount amount on task prices in summation to calculate full discounted job price
		float Price = 0f;
		for (Task t: job.getTasks()) {
			Price += t.getPrice() * (1 - _discountMap.getOrDefault(t.getType(), 0f));
		}
		return Price;
	}
}