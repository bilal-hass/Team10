package Report;

import Controller.DatabaseConnection;
import Controller.Date;

class Shift extends Report {
	private Date _dateOfShift;
	private Date _totalEffort;
	private Date _timeTaken;

	Date getDateOfShift() {
		return this._dateOfShift;
	}

	void setDateOfShift(Date aDateOfShift) {
		this._dateOfShift = aDateOfShift;
	}

	Date getTotalEffort() {
		return this._totalEffort;
	}

	void setTotalEffort(Date aTotalEffort) {
		this._totalEffort = aTotalEffort;
	}

	Date getTimeTaken() {
		return this._timeTaken;
	}

	void setTimeTaken(Date aTimeTaken) {
		this._timeTaken = aTimeTaken;
	}

	@Override
	public void generate() {
		_text = databaseConnection.query("SELECT * FROM Shifts");
	}

	Shift() {
		databaseConnection = new DatabaseConnection();
	}
}