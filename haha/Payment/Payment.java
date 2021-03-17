package Payment;

import Processing.Job;

public class Payment {
	private float _amount;
	public Job _manages;

	public float getAmount() {
		return this._amount;
	}

	public void setAmount(float aAmount) {
		this._amount = aAmount;
	}

	public Payment() {
		throw new UnsupportedOperationException();
	}
}