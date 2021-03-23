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
//	private String _valued;
	public LinkedList<Job> jobs = new LinkedList<>();
	JobHistory jobHistory;

	public Discount discount;

	public Discount getDiscountPlan() {
		return discount;
	}

	public void setDiscount(int intDis) {
		this.discount = new Discount();
	}

	void setAgreedDiscount() {
        //set up discount
		this.discount = new Discount();
	}

	void editCustomerDetails() {
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

	Integer getCustomerId() {
		return this._customerId;
	}

	void setCustomerId(Integer aCustomerId) {
		this._customerId = aCustomerId;
	}

	public String getFirstName() {
		return this._firstName;
	}

	void setFirstName(String aFirstName) {
		this._firstName = aFirstName;
	}

	public String getLastName() {
		return this._lastName;
	}

	void setLastName(String aLastName) {
		this._lastName = aLastName;
	}

	public String getAddress() {
		return this._address;
	}

	void setAddress(String aAddress) {
		this._address = aAddress;
	}

	public String getEmail() {
		return this._email;
	}

	public void setEmail(String aEmail) {
		this._email = aEmail;
	}

	public String getPhoneNumber() {
		return this._phoneNumber;
	}

	void setPhoneNumber(String aPhoneNumber) {
		this._phoneNumber = aPhoneNumber;
	}

//	public String getValued() {
//		return this._valued;
//	}
//
//	public void setValued(String aValued) {
//		this._valued = aValued;
//	}

	CustomerAccount() {
		JobHistory jobHistory = new JobHistory();
		Discount discount = new Discount();
	}
}