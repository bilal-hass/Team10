package Processing;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Discount.DiscountController;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;

public class Controller {
    public static String lastError = "";

    public static CustomerAccount createNewCustomer(String name, String address, String email, String phone) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "INSERT INTO CustomerAccount(`Name`, `Address`, `Phone`, `Email`, `Valued`) VALUES \n"
                + "('" + name + "', '" + address + "', '" + phone + "', '" + email + "', false)";

        try {
            Integer n = conn.createStatement().executeUpdate(query);

        }
        catch(SQLException e) {
            e.printStackTrace();
            lastError = "SQLError: " + e.getMessage();
            return null;
        }

        Integer id = DBConnWrapper.getMax("CustomerAccount", "No");
        CustomerAccount c = new CustomerAccount(id);
        return c;
    }

    public static CustomerAccount getCustomerByEmail(String email) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT * FROM CustomerAccount WHERE Email = '" + email + "';";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Integer id = RS.getInt("No");
                return new CustomerAccount(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CustomerAccount getCustomerByPhone(String phone) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT * FROM CustomerAccount WHERE Phone = '" + phone + "';";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Integer id = RS.getInt("No");
                return new CustomerAccount(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Task createNewTask(Integer Jobid, Integer TaskType, Integer Order) {

        Connection conn = DBConnWrapper.getConnection();
        String query = "INSERT INTO JobTasks(`Order`, `TaskId`, `JobId`, `Completed`, `CompletionStaff`, `CompletionTime`) VALUES\n"
                + "(" + Order.toString() + ", " + TaskType.toString() + ", " + Jobid.toString() + ", false, NULL, NULL);";
        try {
            int n = conn.createStatement().executeUpdate(query);
            if (n == 0) {
                return null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        Task t = new Task(DBConnWrapper.getMaxId("JobTasks"));
        return t;
    }

    public static Job createNewJob(CustomerAccount c, Integer JobType, ArrayList<Integer> TaskTypes) {
        Integer cNo = c.getId();

        Connection conn = DBConnWrapper.getConnection();
        String query = "INSERT INTO Job(`CustomerNo`, `Status`, `JobType`) VALUES (" + cNo.toString() + ", " + "'UNCONFIRMED'," + JobType.toString() + ");";
        try {
            conn.createStatement().executeUpdate(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        Integer jobId = DBConnWrapper.getMaxId("Job");

        int k = 1;
        for (Integer type: TaskTypes) {
            Task t = createNewTask(jobId, type, k);
            k+=1;
        }

        Job j = new Job(jobId, c);
        System.out.println("CREATE NEW JOB CUSTOMER VALUED: " + (c.getValued() ? "YES" : "NO"));
        if (c.getValued()) {
            j.startJob();
        }
        return j;
    }

    public static Boolean addSpecialInstruction(Job j, String Instruction) {
        if (Instruction.length() > 1023) {
            lastError = "SpecialInstruction must be less than 1024 characters, if more space is needed please use multiple instructions.";
            return null;
        }
        Integer id = j.getId();
        Connection conn = DBConnWrapper.getConnection();
        String query = "INSERT INTO SpecialInstruction(`Body`, `Job`) VALUES ('" + Instruction + "', " + id.toString() + ");";
        try {
            Integer n = conn.createStatement().executeUpdate(query);
            if (n.intValue() == 0 ) {
                lastError = "Failed to insert SpecialInstruction, unknown SQL error.";
                return null;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            lastError = "SQLException: " + e.getMessage();
            return null;
        }
        return true;
    }

    //tested & works =)
    public static ArrayList<Job> getCustomerHistoryInRange(CustomerAccount c, long start, long end) {
        Connection conn = DBConnWrapper.getConnection();
        Date sqlDateStart = new Date(start);
        Date sqlDateEnd = new Date((new Date(end)).getTime() + 60*60*24*1000);
        String query = "SELECT * FROM Job AS J WHERE J.Status = 'COMPLETE' AND J.`CustomerNo` = " + c.getId().toString() + " \n"
            + "AND J.`StartDate` BETWEEN '" + sqlDateStart + "' AND '" + sqlDateEnd + "';";
        ArrayList<Job> jobs = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Integer id = RS.getInt("id");
                ids.add(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        for (Integer id: ids) {
            Job j = new Job(id, c);
            jobs.add(j);
        }
        return jobs;
    }

    //tested & works =)
    public static ArrayList<Job> getCustomerHistory(CustomerAccount c) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/mm/dd");
        try {
            Date start = new Date(df.parse("1600/01/01").getTime());
            Date end = new Date(Instant.now().toEpochMilli());
            return getCustomerHistoryInRange(c, start.getTime(), Instant.now().toEpochMilli());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Job> getCustomerUnpaidJobs(CustomerAccount c) {
        Connection conn = DBConnWrapper.getConnection();

        String query = "SELECT * FROM Job AS J WHERE J.`Paid` = 0 AND J.`CustomerNo` = " + c.getId().toString() + ";";
        ArrayList<Job> jobs = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Integer id = RS.getInt("id");
                ids.add(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        for (Integer id: ids) {
            Job j = new Job(id, c);
            jobs.add(j);
        }
        return jobs;
    }

    public static String[] getJobTypes() {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT `JobType` FROM JobTypes;";
        ArrayList<String> jobtypes = new ArrayList<>();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                jobtypes.add(RS.getString("JobType"));
                System.out.println("JOBTYPE: " + RS.getString("JobType"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return jobtypes.toArray(new String[jobtypes.size()]);
    }

    public static String[] getTaskTypeStrings() {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT `TaskName` FROM Task;";
        ArrayList<String> tasktypes = new ArrayList<>();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                tasktypes.add(RS.getString("TaskName"));
                System.out.println("TASKTYPE: " + RS.getString("TaskName"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return tasktypes.toArray(new String[tasktypes.size()]);
    }

    public static ArrayList<TaskTypeFrame> getTaskTypes() {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT * FROM Task;";
        ArrayList<TaskTypeFrame> tasktypes = new ArrayList<>();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                TaskTypeFrame f = new TaskTypeFrame();
                f.TaskType = RS.getInt("TaskType");
                f.TaskName = RS.getString("TaskName");
                f.TaskDescription = RS.getString("TaskDescription");
                f.Location = RS.getString("Location");
                f.Price = RS.getFloat("Price");
                f.Duration = RS.getInt("Duration");

                System.out.println("TASKTYPE: " + RS.getString("taskType"));
                tasktypes.add(f);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return tasktypes;
    }

    public static void createSpecialInstruction(String body, Job j) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "INSERT INTO SpecialInstruction (`Body`, `Job`) VALUES\n"
                + "('" + body + "', " + j.getId().toString() + ")";
        try {
            Integer num = conn.createStatement().executeUpdate(query);
            if (num == 0) {
                throw new RuntimeException("SpecialInstructions failed");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Job> getCurrentJobs() {
        ArrayList<Job> jobs = new ArrayList<>();
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT * FROM Job AS J INNER JOIN CustomerAccount AS C ON J.`CustomerNo` = C.`No`\n"
                            + "WHERE (J.Status = 'CONFIRMED' OR J.Status = 'ACTIVE') OR (J.Status = 'UNCONFIRMED' AND C.Valued = 1) ";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Job j = new Job(RS.getInt("id"), new CustomerAccount(RS.getInt("CustomerNo")));
                jobs.add(j);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }
}
