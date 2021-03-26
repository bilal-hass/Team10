package Processing;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Users.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Job{
    public static Map<Integer, String> JobTypes = new HashMap<Integer, String>();
    static {
        String query = "SELECT * FROM JobTypes";
        Connection conn = DBConnWrapper.getConnection();
        try {
            ResultSet r = conn.createStatement().executeQuery(query);
            while (r.next()) {
                Integer id = r.getInt("id");
                String JobType = r.getString("JobType");
                JobTypes.put(id, JobType);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Set up a map for ID to String for JobTypes from DB in static context so class instance not needed to map ID -> JobType

    private Integer _jobId;
    private CustomerAccount _customer;
    private String _status;
    private Boolean _paid;
    private Date _startDate;
    private Date _completionDate;
    private Integer _jobType;
    private ArrayList<Task> _tasks;

    private void UpdateSQL(String Column, Object value) {
        String query = "UPDATE Job \n SET " + Column + " = " + value.toString() + "\n WHERE id = " + _jobId.toString() + ";";
        Connection conn = DBConnWrapper.getConnection();
        try {
            Integer affected = conn.createStatement().executeUpdate(query);
            if (affected < 1) {
                throw new RuntimeException("Failed to update Job with ID " + _jobId.toString());
            }
            System.out.println("Updated Job " + _jobId.toString() + " `" + Column + "`");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Job(Integer id, CustomerAccount customer) {
        _jobId = id;
        _customer = customer;

        String query = "SELECT * FROM Job WHERE Job.`id` = " + id.toString() + ";";
        Connection conn = DBConnWrapper.getConnection();

        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                _status = RS.getString("Status");
                _paid = RS.getBoolean("Paid");
                RS.getInt("CustomerNo");
                _jobType = RS.getInt("JobType");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        _tasks = new ArrayList<Task>();

        query = "SELECT JT.id FROM JobTasks AS JT WHERE JT.JobId = " + id.toString() + ";";

        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Integer t_id = RS.getInt("id");
                Task t = new Task(t_id);
                _tasks.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //should load the Tasks automatically of the Job instance...
    }

    public Integer getId() { return _jobId; }
    public CustomerAccount getCustomer() { return _customer; }
    public String getStatus() { return _status; }
    public Boolean getPaid() { return _paid; }
    public Integer getType() { return _jobType; }
    public String getTypeString() { return JobTypes.get(_jobType); }

    public void setStatus(String status) {
        _status = status;
        UpdateSQL("Status", status);
    }

    public Boolean isDoable() {
        CustomerAccount c = getCustomer();
        if (getStatus().equals("CONFIRMED") || !isPaid() && c.isValuedCustomer()) {
            return true;
        }
        return false;
    }

    public void confirmJob() {
        setStatus("CONFIRMED");
    }

    public Boolean isPaid() {
        return !getStatus().equals("UNCONFIRMED");
    }

    public void startJob() {
        if (!getPaid()) {
            System.out.println("Started unpaid job ID " + getId().toString() + " check Customer is Valued!");
        }
        setStatus("ACTIVE");
    }

    public void completeJob(User CompletedBy) {
        setStatus("COMPLETE");
        for (Task t: _tasks) {
            t.completeTask(CompletedBy);
            //sanity complete all tasks when job completes.
        }
    }

    public ArrayList<Task> getTasks() {
        return _tasks;
    }

    public Float getPriceBeforeDiscount() {
        //THIS DOES NOT FACTOR DISCOUNTS, PLEASE DO NOT USE UNLESS TO CALCULATE PREDISCOUNT PRICE =)
        Float price = 0.f;
        for (Task t: _tasks) {
            price += t.getPrice();
        }
        return price;
    }

}
