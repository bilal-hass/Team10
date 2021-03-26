package Account;

import Controller.DatabaseConnection;

import java.util.ArrayList;
import java.util.List;

class AccountController {

	ArrayList<CustomerAccount> customerAccounts;
	private DatabaseConnection databaseConnection = new DatabaseConnection();

	void createCustomer() {
		CustomerAccount customerAccount = new CustomerAccount();
		// filling out attributes through GUI
		customerAccount.setCustomerId(0);
		customerAccount.setFirstName("");
		customerAccount.setLastName("");
		customerAccount.setAddress("");
		customerAccount.setPhoneNumber("");
		customerAccount.editCustomerDetails();
	}

	void deleteCustomer(CustomerAccount customerAccount) {
		databaseConnection.query(
				"DELETE * FROM Customer WHERE CustID = " + customerAccount.getCustomerId()
		);
		customerAccounts.remove(customerAccount);
	}

	void upgradeCustomer(CustomerAccount customerAccount) {
		customerAccount.setAgreedDiscount();
	}

	void downgradeCustomer(CustomerAccount customerAccount) {
		customerAccount.setAgreedDiscount();
	}

	void modifyJobHistory(CustomerAccount customerAccount) {
		customerAccount.jobHistory.editJobHistory(customerAccount.getCustomerId());
	}

	void viewJobHistory(CustomerAccount customerAccount) {
		List<String> jobsFromDatabase = customerAccount.jobHistory.getJobsFromDatabase(customerAccount.getCustomerId());
		for (String job : jobsFromDatabase) {
			System.out.println(job);
		}
	}

	AccountController() {
		// might wana get accounts from database and add them to the array
	}
}