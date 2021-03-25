package Discount;

import Account.*;
import Processing.Job;

public class Discount {
	public static enum DiscountTypes {
		FIXED,
		VARIABLE,
		FLEXIBLE
	};

	private DiscountTypes _type;
	private Integer _discountPlanId;
	private String _name;
	private String _description;

	public Discount(Integer id, String name, String description, DiscountTypes type) {
		_discountPlanId=id;
		_name=name;
		_description = description;
		_type = type;
	}

	public Float getPrice(Job job) {
		return job.getPriceBeforeDiscount();
	}

	public DiscountTypes getType() {
		return _type;
	}

	public Integer getId() {
		return _discountPlanId;
	}
}