package Processing;

import Controller.Date;
import java.util.LinkedList;
import Processing.Task;

public class TaskType {
	private String _room;
	private String _description;
	private float _price;
	private Date _duration;
	private String _department;
	public LinkedList<Task> _defines = new LinkedList<Task>();

	public String getRoom() {
		return this._room;
	}

	public void setRoom(String aRoom) {
		this._room = aRoom;
	}

	public String getDescription() {
		return this._description;
	}

	public void setDescription(String aDescription) {
		this._description = aDescription;
	}

	public float getPrice() {
		return this._price;
	}

	public void setPrice(float aPrice) {
		this._price = aPrice;
	}

	public Date getDuration() {
		return this._duration;
	}

	public void setDuration(Date aDuration) {
		this._duration = aDuration;
	}

	public String getDepartment() {
		return this._department;
	}

	public void setDepartment(String aDepartment) {
		this._department = aDepartment;
	}

	public TaskType() {
		throw new UnsupportedOperationException();
	}
}