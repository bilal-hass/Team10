package Users;

import DB.DBConnWrapper;
import Processing.Task;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private Integer _id;
    private Integer _role;
    private String _name;
    private String _address;
    private String _department;

    public User(Integer id) {
        _id = id;
        getUserDBInfo();
    }

    private void getUserDBInfo() {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT SA.`Role`, SA.`Name`, SA.`Address`, SA.`Department` FROM StaffAccount AS SA;";
        try {
            ResultSet RS =  conn.createStatement().executeQuery(query);
            while (RS.next()) {
                _role = RS.getInt("Role");
                _name = RS.getString("Name");
                _address = RS.getString("Address");
                _department = RS.getString("Department");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return _id;
    }
    public Integer getRole() {
        return _role;
    }
    public String getName() {
        return _name;
    }
    public String getAddress() {
        return _address;
    }
    public String getDepartment() {
        return _department;
    }
    public void setRole(Integer role) {
        _role = role;
    }
    public void setName(String name) {
        _name = name;
    }
    public void setAddress(String address) {
        _address = address;
    }
    public void setDepartment(String department) {
        _department = department;
    }

    /* OFFICEMANAGER */
    public void backupDatabase() {
        //unimplemented lol
    }
    public void recoverDatabase(String path) {
        //unimplemented lol
    }

    //tested & works =)
    public ArrayList<Task> getCompletedTasksInTimespan(Date StartDate, Date EndDate) {
        ArrayList<Task> tasks = new ArrayList<>();
        String query = "SELECT JT.`id` FROM JobTasks AS JT WHERE CompletionStaff = " + getId().toString() + " AND CompletionTime BETWEEN '" + StartDate.toString() + "' AND '" + EndDate.toString() + "'";
        Connection conn = DBConnWrapper.getConnection();
        System.out.println(query);
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Task t = new Task(RS.getInt("id"));
                tasks.add(t);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }


}
