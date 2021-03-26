package Account;

public class AccountImplemenation implements Account_Interface {

	private AccountController accountController = new AccountController();

	public void findCustomerAccount(Integer aCustomerId) {
		for (CustomerAccount customerAccount : accountController.customerAccounts) {
			if (customerAccount.getCustomerId() == aCustomerId) {
				// we found it
				break;
			}
		}
		System.out.println("not found :(");
	}

	public void modifyCustomerDetails(Integer aCustomerId) {
		for (CustomerAccount customerAccount : accountController.customerAccounts) {
			if (customerAccount.getCustomerId() == aCustomerId) {
				customerAccount.editCustomerDetails();
				break;
			}
		}
		System.out.println("Customer not found!");
	}

	public void newCustomer() {
		CustomerAccount customerAccount = new CustomerAccount();
		// filling out attibutes through GUI
		customerAccount.setCustomerId(0);
		customerAccount.setFirstName("");
		customerAccount.setLastName("");
		customerAccount.setAddress("");
		customerAccount.setPhoneNumber("");
	}

	public void manageJobHistory(Integer aCustomerId) {
		for (CustomerAccount customerAccount : accountController.customerAccounts) {
			if (customerAccount.getCustomerId() == aCustomerId) {
				customerAccount.jobHistory.editJobHistory(aCustomerId);
				break;
			}
		}
		System.out.println("Customer not found!");
	}

	public AccountImplemenation() { }

}