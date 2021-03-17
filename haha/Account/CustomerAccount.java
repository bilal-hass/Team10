package Account;

import java.util.Vector;
import Processing.Job;
import Discount.Discount;

public class CustomerAccount {
	private Integer _customerId;
	private String _firstName;
	private String _lastName;
	private String _address;
	private String _email;
	private Integer _phoneNumber;
	private String _valued;
	public Vector<Job> _belongs_to = new Vector<Job>();
	public JobHistory _unnamed_JobHistory_232;
	public Discount _can_have;

	public DiscountPlan getDiscountPlan() {
		throw new UnsupportedOperationException();
	}

	public void setAgreedDiscount() {
		throw new UnsupportedOperationException();
	}

	public void editCustomerDetails() {
		throw new UnsupportedOperationException();
	}

	public Integer getCustomerId() {
		return this._customerId;
	}

	public void setCustomerId(Integer aCustomerId) {
		this._customerId = aCustomerId;
	}

	public String getFirstName() {
		return this._firstName;
	}

	public void setFirstName(String aFirstName) {
		this._firstName = aFirstName;
	}

	public String getLastName() {
		return this._lastName;
	}

	public void setLastName(String aLastName) {
		this._lastName = aLastName;
	}

	public Varchar getAddress() {
		throw new UnsupportedOperationException();
	}

	public void setAddress(Varchar aAddress) {
		throw new UnsupportedOperationException();
	}

	public Varchar getEmail() {
		throw new UnsupportedOperationException();
	}

	public void setEmail(Varchar aEmail) {
		throw new UnsupportedOperationException();
	}

	public Integer getPhoneNumber() {
		return this._phoneNumber;
	}

	public void setPhoneNumber(Integer aPhoneNumber) {
		this._phoneNumber = aPhoneNumber;
	}

	public String getValued() {
		return this._valued;
	}

	public void setValued(String aValued) {
		this._valued = aValued;
	}

	public CustomerAccount() {
		throw new UnsupportedOperationException();
	}
}