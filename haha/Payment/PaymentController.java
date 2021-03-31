package Payment;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Processing.Job;

import java.sql.Connection;
import java.sql.SQLException;

public class PaymentController {


    public static Payment createNewPayment(Job j, String PaymentOption, String CardNumber) {
        String query = "INSERT INTO Payment(`Job`, `Amount`, `PaymentOption`, `CardNumber`) VALUES\n"+
                "(" + j.getId().toString() + ", " + j.getCustomer().getDiscountPlan().getPrice(j).toString() + ", '" + PaymentOption + "', '" + CardNumber + "')";
        Connection conn = DBConnWrapper.getConnection();
        try {
            Integer n = conn.createStatement().executeUpdate(query);
            if (n == 0) {
                throw new RuntimeException("Failed to create new payment");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (!j.getCustomer().hasCardStored(CardNumber) && CardNumber.length() > 5 && PaymentOption.equals("Card")) {
            j.getCustomer().storeCard(CardNumber);
        }

        Integer id = DBConnWrapper.getMaxId("Payment");
        return new Payment(id, j, j.getCustomer());
    }

    public static Payment createNewPayment(Job j, String PaymentOption) {
        return createNewPayment(j, PaymentOption, "");
    }

    public static void saveCardDetails(CustomerAccount c, String CardNumber) {
        if (!c.hasCardStored(CardNumber)) {
            c.storeCard(CardNumber);
        }
    }
}
