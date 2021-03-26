package Account;

import java.util.LinkedList;

import Controller.DatabaseConnection;
import Processing.Job;
import Discount.Discount;

public class CustomerAccount {
	private Integer _customerId;
	private String _firstName;
	private String _lastName;
	private String _address;
	private String _email;
	private String  _phoneNumber;
	private String _valued;
	public LinkedList<Job> jobs = new LinkedList<Job>();
	public JobHistory jobHistory;

	public Discount discount;

	public Discount getDiscountPlan() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public void setAgreedDiscount() {
		Discount discount = new Discount();
		//set up discount
		this.discount = discount;
	}

	public void editCustomerDetails() {
		// GUI to change deets
		DatabaseConnection databaseConnection = new DatabaseConnection();
		databaseConnection.query(String.format(
				"UPDATE CustomerAccounts " +
						"SET Name = %s " +
						"Address = %s " +
						"Phone = %s" +
						"AgreedDiscountType = %s" +
						this._lastName + this._lastName,
						this._address,
						this._phoneNumber,
						this.discount,
						"WHERE CustomerID = " + this._customerId
				)
		);
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

	public String getAddress() {
		throw new UnsupportedOperationException();
	}

	public void setAddress(String aAddress) {
		throw new UnsupportedOperationException();
	}

	public String getEmail() {
		throw new UnsupportedOperationException();
	}

	public void setEmail(String aEmail) {
		throw new UnsupportedOperationException();
	}

	public String getPhoneNumber() {
		return this._phoneNumber;
	}

	public void setPhoneNumber(String aPhoneNumber) {
		this._phoneNumber = aPhoneNumber;
	}

	public String getValued() {
		return this._valued;
	}

	public void setValued(String aValued) {
		this._valued = aValued;
	}

	public CustomerAccount() {
		JobHistory jobHistory = new JobHistory();
		Discount discount = new Discount();
	}
}