package Users;


import Account.CustomerAccount;
import Discount.DiscountController;
import Processing.Controller;
import Processing.Job;
import Processing.Task;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class test {
    public static void tmain(String[] args) {

        User OfficeManager = UserController.tryLogIn("OfficeManager1", "Password1");

        CustomerAccount testcustomer = Controller.createNewCustomer("Java Customer", "JavaTown", "Java@Java.com", "123456789xx");
        testcustomer.setValued(true);

        Discount.Discount d = DiscountController.createFixedDiscountPlan("Java5Off", "5% Discount on all prices", .05f);


        ArrayList<Integer> TaskTypes = new ArrayList<>(Arrays.asList(1,2,4,5,3));
        Job j = Controller.createNewJob(testcustomer, 1, TaskTypes);

        j.setPaid();
        System.out.println(testcustomer.getDiscountPlan().getPrice(j).toString());
        testcustomer.setDiscount(d);
        System.out.println(testcustomer.getDiscountPlan().getPrice(j).toString());
    }
}
