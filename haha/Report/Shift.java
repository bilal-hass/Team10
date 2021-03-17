package Report;

import Controller.Date;

public class Shift extends Report {
	private Date _dateOfShift;
	private Time _totalEffort;
	private TIme _timeTaken;

	public Date getDateOfShift() {
		return this._dateOfShift;
	}

	public void setDateOfShift(Date aDateOfShift) {
		this._dateOfShift = aDateOfShift;
	}

	public Time getTotalEffort() {
		return this._totalEffort;
	}

	public void setTotalEffort(Time aTotalEffort) {
		this._totalEffort = aTotalEffort;
	}

	public TIme getTimeTaken() {
		return this._timeTaken;
	}

	public void setTimeTaken(TIme aTimeTaken) {
		this._timeTaken = aTimeTaken;
	}

	public Shift() {
		throw new UnsupportedOperationException();
	}
}