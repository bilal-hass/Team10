package Processing;

import Controller.Date;
import Account.CustomerAccount;
import Payment.Payment;

public class Job {
	private Date _urgency;
	private int _customerNo;
	private boolean _confirmedStatus;
	private boolean _completedStatus;
	private boolean _paid;
	private int _job_ID;
	public JobsCollection _has_multiple;
	public SpecialInstructions _unnamed_SpecialInstructions_;
	public CustomerAccount _belongs_to;
	public Payment _manages;

	public String printLabel() {
		throw new UnsupportedOperationException();
	}

	public Date getUrgency() {
		return this._urgency;
	}

	public void setUrgency(Date aUrgency) {
		this._urgency = aUrgency;
	}

	public int getCustomerNo() {
		return this._customerNo;
	}

	public void setCustomerNo(int aCustomerNo) {
		this._customerNo = aCustomerNo;
	}

	public boolean getConfirmedStatus() {
		return this._confirmedStatus;
	}

	public void setConfirmedStatus(boolean aConfirmedStatus) {
		this._confirmedStatus = aConfirmedStatus;
	}

	public boolean getCompletedStatus() {
		return this._completedStatus;
	}

	public void setCompletedStatus(boolean aCompletedStatus) {
		this._completedStatus = aCompletedStatus;
	}

	public boolean getPaid() {
		return this._paid;
	}

	public void setPaid(boolean aPaid) {
		this._paid = aPaid;
	}

	public int getJob_ID() {
		return this._job_ID;
	}

	public void setJob_ID(int aJob_ID) {
		this._job_ID = aJob_ID;
	}

	public Job() {
		throw new UnsupportedOperationException();
	}
}