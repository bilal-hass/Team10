package Account;

import Controller.DatabaseConnection;
import Discount.Discount;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AccountController {

	ArrayList<CustomerAccount> customerAccounts;

	public void createCustomer() {
		customerAccounts.add(new CustomerAccount());
	}

	public void deleteCustomer(CustomerAccount customerAccount) {
		customerAccounts.remove(customerAccount);
	}

	public void upgradeCustomer(CustomerAccount customerAccount) {
		customerAccount.setAgreedDiscount();
	}

	public void downgradeCustomer(CustomerAccount customerAccount) {
		customerAccount.setAgreedDiscount();
	}

	public void modifyJobHistory() {

	}

	public void viewJobHistory(CustomerAccount customerAccount) {
		List<String> jobsFromDatabase = customerAccount.jobHistory.getJobsFromDatabase(customerAccount.getCustomerId());
		for (String job : jobsFromDatabase) {
			System.out.println(job);
		}
	}

	public AccountController() {
		// might wana get accounts from database and add them to the array
		DatabaseConnection databaseConnection = new DatabaseConnection();
		String[] split = databaseConnection.query("SELECT * FROM CustomerAccounts").split(";");
		for (String strAcc : split) {
			String[] splitAcc = strAcc.split(",");
			CustomerAccount customerAccount = new CustomerAccount();
			customerAccount.setCustomerId(Integer.parseInt(splitAcc[0]));
			customerAccount.setFirstName(splitAcc[1].split(" ")[0]);
			customerAccount.setFirstName(splitAcc[1].split(" ")[1]);
			customerAccount.setAddress(splitAcc[1]);
			customerAccount.setPhoneNumber(splitAcc[2]);
			customerAccount.setDiscount(new Discount());
			//err not sure about the last one haha
		}
	}
}