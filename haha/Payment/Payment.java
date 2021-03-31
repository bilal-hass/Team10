package Payment;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Processing.Job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Payment {
    private Job _job;
    private Float _amount;
    private Integer _id;

    private void UpdateSQL(String Column, Object Value) {
        if (Value instanceof String) {
            Value = "'" + Value + "'";
        }
        String query = "UPDATE Payment SET " + Column + " = " + Value.toString() + " WHERE id = " + _id.toString();
    }

    public Payment(Integer id, Job j, CustomerAccount c) {
        _id = id;
        _job = j;
        String query = "SELECT * FROM Payment WHERE id = " + id.toString();
        Connection conn = DBConnWrapper.getConnection();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                _amount = RS.getFloat("Amount");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Float getAmount() {
        return _amount;
    }

    public Integer getId() {
        return _id;
    }

    public Job getJob() {
        return _job;
    }

}
