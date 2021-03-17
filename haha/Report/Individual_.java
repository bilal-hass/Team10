package Report;

import Controller.Date;

public class Individual_ extends Report {
	private Integer _customerId;
	private Date _startDate;
	private Date _endDate;

	public Integer getCustomerId() {
		return this._customerId;
	}

	public void setCustomerId(Integer aCustomerId) {
		this._customerId = aCustomerId;
	}

	public Date getStartDate() {
		return this._startDate;
	}

	public void setStartDate(Date aStartDate) {
		this._startDate = aStartDate;
	}

	public Date getEndDate() {
		return this._endDate;
	}

	public void setEndDate(Date aEndDate) {
		this._endDate = aEndDate;
	}

	public Individual_() {
		throw new UnsupportedOperationException();
	}
}