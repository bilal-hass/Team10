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
		if (this instanceof VariableDiscount) {
			return ((VariableDiscount) this).getVariablePrice(job);
		}
		else if (this instanceof FlexibleDiscount) {
			return ((FlexibleDiscount) this).getFlexiblePrice(job);
		}
		else if (this instanceof FixedDiscount) {
			return ((FixedDiscount) this).getFixedPrice(job);
		}
		return job.getPriceBeforeDiscount();
	}

	public void delete() {
		if (this instanceof VariableDiscount) {
			((VariableDiscount) this).deleteVariable();
		}
		else if (this instanceof FlexibleDiscount) {
			((FlexibleDiscount) this).deleteFlexible();
		}
		else if (this instanceof FixedDiscount) {
			((FixedDiscount) this).deleteFixed();
		}

	}

	public DiscountTypes getType() {
		return _type;
	}

	public Integer getId() {
		return _discountPlanId;
	}

	public String getName() {
		return _name;
	}

	public String getDescription() {
		return _description;
	}
}