package Discount;


import java.util.ArrayList;
import java.util.Map;
import Processing.Job;
import Processing.Task;

public class VariableDiscount extends Discount {
	private Map<Integer, Float> _discountMap; //TaskType -> Percentage

	public VariableDiscount(Integer customerId, Integer id, String name, String description) {
		super(customerId, id, name, description, DiscountTypes.VARIABLE);
	}
}