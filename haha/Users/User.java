package Users;

public class User {
	private int _role;
	private String _name;
	private String _address;
	private String _department;
	public OfficeManager _manages;
	public Users_IMP _unnamed_Users_IMP_;

	public int getRole() {
		return this._role;
	}

	public void setRole(int aRole) {
		this._role = aRole;
	}

	public String getName() {
		return this._name;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public String getAddress() {
		return this._address;
	}

	public void setAddress(String aAddress) {
		this._address = aAddress;
	}

	public String getDepartment() {
		return this._department;
	}

	public void setDepartment(String aDepartment) {
		this._department = aDepartment;
	}

	public User() {
		throw new UnsupportedOperationException();
	}
}