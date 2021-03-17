package Report;

import Users.User;

public class Performance extends Report {
	private User _staff;

	public User getStaff() {
		return this._staff;
	}

	public void setStaff(User aStaff) {
		this._staff = aStaff;
	}

	public Performance() {
		throw new UnsupportedOperationException();
	}

	public Performance(Object aParameter) {
		throw new UnsupportedOperationException();
	}
}