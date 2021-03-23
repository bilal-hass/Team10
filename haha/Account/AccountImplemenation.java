package Account;

import Controller.DatabaseConnection;

public class AccountImplemenation implements Account_Interface {

    private AccountController accountController;
    private DatabaseConnection databaseConnection;

	public void findCustomerAccount(Integer aCustomerId) {
        String db_info = databaseConnection.query(
                "SELECT * FROM CustomerAccounts WHERE CustomerID = " + aCustomerId
        );

        // catch if no account exists / if 2 accounts exists
        if (db_info.isEmpty()) {
            System.out.println("no account exists");
            return;
        } else if (db_info.indexOf(';') != -1) {
            System.out.println("multiple accounts exist");
            return;
        }

        String[] splitAcc = db_info.split(",");
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setCustomerId(Integer.parseInt(splitAcc[0]));
        customerAccount.setFirstName(splitAcc[1].split(" ")[0]);
        customerAccount.setLastName(splitAcc[1].split(" ")[1]);
        customerAccount.setAddress(splitAcc[1]);
        customerAccount.setPhoneNumber(splitAcc[2]);
        customerAccount.setEmail(splitAcc[3]);
        customerAccount.setDiscount(Integer.parseInt(splitAcc[4]));
        //err not sure about the last one haha
        accountController.customerAccounts.add(customerAccount);
	}

	public void modifyCustomerDetails(Integer aCustomerId) {
		for (CustomerAccount customerAccount : accountController.customerAccounts) {
			if (customerAccount.getCustomerId().equals(aCustomerId)) {
				customerAccount.editCustomerDetails();
                accountController.deleteCustomer(customerAccount);
                accountController.upgradeCustomer(customerAccount);
                accountController.downgradeCustomer(customerAccount);
			}
		}
		System.out.println("Customer not found!");
	}

	public void newCustomer() {
	    accountController.createCustomer();
	}

	public void manageJobHistory(Integer aCustomerId) {
		for (CustomerAccount customerAccount : accountController.customerAccounts) {
			if (customerAccount.getCustomerId().equals(aCustomerId)) {
				customerAccount.jobHistory.editJobHistory(aCustomerId);
				break;
			}
            accountController.modifyJobHistory(customerAccount);
            accountController.viewJobHistory(customerAccount);
		}
		System.out.println("Customer not found!");
	}

	public AccountImplemenation() {
        accountController = new AccountController();
        databaseConnection = new DatabaseConnection();
    }

}