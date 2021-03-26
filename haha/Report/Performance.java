package Report;

import Controller.DatabaseConnection;
import Users.User;

class Performance extends Report {
	private User _staff;

	User getStaff() {
		return this._staff;
	}

	void setStaff(User aStaff) {
		this._staff = aStaff;
	}

	@Override
	void generate() {
		databaseConnection.query(
				"SLELECT * FROM Shifts WHERE StaffID = " + _staff.getName());
	}

	Performance() {
		databaseConnection = new DatabaseConnection();
	}
}