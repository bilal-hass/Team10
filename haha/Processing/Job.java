package Processing;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Users.User;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Timestamp _startDate;
    private Timestamp _completionDate;
    private Integer _jobType;
    private ArrayList<Task> _tasks;
    private ArrayList<String> _specialInstructions = new ArrayList<>();
    private Integer _urgency;

    private void UpdateSQL(String Column, Object value) {
        if (value instanceof String) {
            value = "\"" + value + "\"";
        }
        String query = "UPDATE Job \n SET " + Column + " = " + value.toString() + "\n WHERE id = " + _jobId.toString() + ";";
        System.out.println(query);
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
    public void setUrgency(Integer urgency) {
        _urgency = urgency;
        UpdateSQL("Urgency", urgency);
    }

    public long getRemainingTime() {
        long TotalTime;
        switch (_urgency) {
            case 0:
                TotalTime = 3600*24;
                break;
            case 1:
                TotalTime = 3600*6;
                break;
            case 2:
                TotalTime = 3600*3;
                break;
            case 3:
                TotalTime = 3600*2;
                break;
            default:
                TotalTime = 3600*24;
                break;
        }

        Long StartTime = (_startDate == null) ? Time.from(Instant.now()).getTime() : _startDate.getTime();

        Long CurrentTime = Time.from(Instant.now()).getTime();

        return TotalTime*1000 - (CurrentTime - StartTime);
    }

    public long getBookingTime() {

        return Time.from(Instant.now()).getTime() - ((_startDate == null) ? Time.from(Instant.now()).getTime() : _startDate.getTime());
    }

    public Job(Integer id, CustomerAccount customer) {
        _jobId = id;
        _customer = customer;
        _urgency = 0;

        String query = "SELECT * FROM Job WHERE Job.`id` = " + id.toString() + ";";
        Connection conn = DBConnWrapper.getConnection();

        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                _status = RS.getString("Status");
                _paid = RS.getBoolean("Paid");
                RS.getInt("CustomerNo");
                _jobType = RS.getInt("JobType");
                _urgency = RS.getInt("Urgency");
                _startDate = RS.getTimestamp("StartDate");
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
        if (getStatus().equals("CONFIRMED") || !isPaid() && c.getValued()) {
            return true;
        }
        return false;
    }

    public void setPaid() {
        _paid = true;
        UpdateSQL("Paid", (Integer)1);
        if (!getStatus().equals("CONFIRMED") && !getStatus().equals("COMPLETE")) {
            setStatus("CONFIRMED");
            UpdateSQL("StartDate", (new Timestamp(Instant.now().toEpochMilli())).toString() );
        }
    }

    public Boolean isPaid() {
        return !getStatus().equals("UNCONFIRMED");
    }

    public void startJob() {
        if (!getPaid()) {
            System.out.println("Started unpaid job ID " + getId().toString() + " check Customer is Valued!");
        }
        setStatus("ACTIVE");
        UpdateSQL("StartDate", (new Timestamp(Instant.now().toEpochMilli())).toString() );
    }

    public void completeJob(User CompletedBy) {
        setStatus("COMPLETE");
        UpdateSQL("CompletionDate", Timestamp.from(Instant.now()).toString() );
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
        price = price + Math.max(0f, ((_urgency-1) * 100f));
        return price;
    }

    private void loadSpecialInstructions() {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT `Body` FROM SpecialInstruction WHERE Job = " + getId().toString() + ";";
        _specialInstructions = new ArrayList<>();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                String body = RS.getString("Body");
                _specialInstructions.add(body);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSpecialInstructions() {
        loadSpecialInstructions();
        String instructions = "";
        for (String s: _specialInstructions) {
            instructions += " " + s;
        }
        return instructions;
    }

    public void checkCompleted(User u) {
        for (Task t: getTasks()) {
            if (!t.getCompleted()) {
                return;
            }
        }
        completeJob(u);
    }

    private String getUrgencyString() {
        switch (_urgency) {
            case 2:
                return "6 Hours";
            case 3:
                return "3 Hours";
            case 4:
                return "2 Hours";

            default:
                return "24 Hours";
        }
    }

    @Override
    public String toString() {
        String OutputStr = "";

        OutputStr = ("=").repeat(10) + " JOB " + getId().toString() + " " + ("=").repeat(10) + "\n"
                + "Started " + _startDate.toString() + "\n"
                + "Price £" + getCustomer().getDiscountPlan().getPrice(this).toString() + "\n"
                + "Urgency " + getUrgencyString() + "\n"
                + "JobType " + getTypeString() + "\n"
                + "Specialinstructions " + getSpecialInstructions() + "\n"
                + "--- CUSTOMER ---\n"
                + getCustomer().toString() + "\n"
                + "---\n"
                + ("=").repeat(5) + " TASKS " + ("=").repeat(5) + "\n";

        for (Task t: getTasks()) {
            OutputStr = OutputStr + t.toString() + "\n---";
        }

        return OutputStr;
    }
}
