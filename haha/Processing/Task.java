package Processing;

import Controller.Date;

public class Task {
	private TaskType _type;
	private int _status;
	private Date _startTime;
	private String _staff_Name;
	private Time _estimatedTimeLeft;
	public SpecialInstructions _unnamed_SpecialInstructions_;
	public TaskCollection _stores;
	public TaskType _defines;

	public TaskType getType() {
		return this._type;
	}

	public void setType(TaskType aType) {
		this._type = aType;
	}

	public int getStatus() {
		return this._status;
	}

	public void setStatus(int aStatus) {
		this._status = aStatus;
	}

	public Date getStartTime() {
		return this._startTime;
	}

	public void setStartTime(Date aStartTime) {
		this._startTime = aStartTime;
	}

	public String getStaff_Name() {
		return this._staff_Name;
	}

	public void setStaff_Name(String aStaff_Name) {
		this._staff_Name = aStaff_Name;
	}

	public Time getEstimatedTimeLeft() {
		return this._estimatedTimeLeft;
	}

	public void setEstimatedTimeLeft(Time aEstimatedTimeLeft) {
		this._estimatedTimeLeft = aEstimatedTimeLeft;
	}

	public Task() {
		throw new UnsupportedOperationException();
	}
}