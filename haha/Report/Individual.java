package Report;

import Controller.DatabaseConnection;
import Controller.Date;

class Individual extends Report {
	private Integer _customerId;
	private Date _startDate;
	private Date _endDate;

	Integer getCustomerId() {
		return this._customerId;
	}

	void setCustomerId(Integer aCustomerId) {
		this._customerId = aCustomerId;
	}

	Date getStartDate() {
		return this._startDate;
	}

	void setStartDate(Date aStartDate) {
		this._startDate = aStartDate;
	}

	Date getEndDate() {
		return this._endDate;
	}

	void setEndDate(Date aEndDate) {
		this._endDate = aEndDate;
	}

	@Override
	void generate() {
		databaseConnection = new DatabaseConnection();
		_text = databaseConnection.query(
				"SELECT * FROM Job WHERE CustomerNo = " + _customerId +
						", " + _startDate + " <= startDate <= " + _endDate
		);
	}

	Individual() {
		databaseConnection = new DatabaseConnection();
	}
}