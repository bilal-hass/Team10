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
import com.mysql.cj.x.protobuf.MysqlxCrud;

public class VariableDiscount extends Discount {
	private Map<Integer, Float> _discountMap = new HashMap<Integer, Float>(); //TaskType -> Percentage
	private Integer _VariableDiscountId;

	public VariableDiscount(Integer id, String name, String description) {
		super(id, name, description, DiscountTypes.VARIABLE);

		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT VD.id FROM DiscountPlan AS DP\n" +
				"INNER JOIN VariableDiscount AS VD ON VD.id = DP.VariableDiscount\n" +
				"WHERE DP.id = " + id.toString() + ";";
		System.out.println("Try find DiscountPlan with id " + id.toString());
		try {
			ResultSet RS = conn.createStatement().executeQuery(query);
			while (RS.next()) {
				_VariableDiscountId = RS.getInt("id");
				System.out.println("Variable Discount With ID " + _VariableDiscountId.toString());
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdateDiscountValues() {
		_discountMap = new HashMap<Integer, Float>();

		Connection conn = DBConnWrapper.getConnection();
		String query = "SELECT VD.id, VTA.Amount, VTA.TaskType FROM DiscountPlan AS DP\n" +
				"INNER JOIN VariableDiscount AS VD ON VD.id = DP.VariableDiscount\n" +
				"INNER JOIN VariableTaskAmounts AS VTA ON VTA.VariableDiscount = VD.id\n" +
				"INNER JOIN Task AS T ON T.TaskType = VTA.TaskType\n" +
				"WHERE DP.id = " + getId().toString() + ";";

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
		return Price * 1.2f;
	}

	public Integer getVariableDiscountId() {
		return _VariableDiscountId;
	}

	public void deleteVariable() {
		String query = "DELETE FROM VariableDiscount WHERE id = " + _VariableDiscountId.toString();
		Connection conn = DBConnWrapper.getConnection();
		try {
			conn.createStatement().executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}