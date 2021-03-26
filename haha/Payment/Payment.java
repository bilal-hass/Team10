package Payment;

import Controller.DatabaseConnection;
import Controller.Date;

public class Payment {
	private float _amount;
	int JobID;
	Date _dateOfPayment;
	DatabaseConnection databaseConnection;

	public float getAmount() {
		return this._amount;
	}

	public void setAmount(float aAmount) {
		this._amount = aAmount;
	}

	public int getJobID() {
		return JobID;
	}

	public void setJobID(int jobID) {
		JobID = jobID;
	}

	public Date getDateOfPayment() {
		return this._dateOfPayment;
	}

	public void setDateOfPayment(Date aDateOfPayment) {
		this._dateOfPayment = aDateOfPayment;
	}

	public void write(){

	}

	public Payment() {
		throw new UnsupportedOperationException();
	}
}