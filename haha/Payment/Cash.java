package Payment;

import Controller.Date;

public class Cash extends Payment {
	private Date _dateOfPayment;

	public Date getDateOfPayment() {
		return this._dateOfPayment;
	}

	public void setDateOfPayment(Date aDateOfPayment) {
		this._dateOfPayment = aDateOfPayment;
	}
}