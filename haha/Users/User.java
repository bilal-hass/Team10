package Users;

import DB.DBConnWrapper;
import Processing.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class User {
    private Integer _id;
    private Integer _role;
    private String _name;
    private String _address;
    private String _department;
    private String _username;
    private String _password;
    private ArrayList<Integer> _permissions;
    public static HashMap<String, Integer> RoleIDs = new HashMap<String, Integer>();
    public static HashMap<Integer, String> RoleNames = new HashMap<Integer, String>();
    static {
        RoleIDs.put("OfficeManager", 1);
        RoleIDs.put("ShiftManager", 2);
        RoleIDs.put("Receptionist", 3);
        RoleIDs.put("Technician", 4);
        RoleNames.put(1, "OfficeManager");
        RoleNames.put(2, "ShiftManager");
        RoleNames.put(3, "Receptionist");
        RoleNames.put(4, "Technician");
    }

    public User(Integer id) {
        _id = id;
        getUserDBInfo();
        if (_role == null) { return; }
        if (_role.equals(1)) {
            _permissions = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        }
        else if (_role.equals(2)) {
            _permissions = new ArrayList<Integer>(Arrays.asList(2,3,4));
        }
        else if (_role.equals(3)) {
            _permissions = new ArrayList<Integer>(Arrays.asList(3));
        }
        else if (_role.equals(4)) {
            _permissions = new ArrayList<Integer>(Arrays.asList(4));
        }
    }

    private void getUserDBInfo() {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT * FROM StaffAccount AS SA WHERE SA.`id` = " + _id.toString() + ";";
        try {
            ResultSet RS =  conn.createStatement().executeQuery(query);
            while (RS.next()) {
                _role = RS.getInt("Role");
                _name = RS.getString("Name");
                _address = RS.getString("Address");
                _department = RS.getString("Department");
                _username = RS.getString("Username");
                _password = RS.getString("Password");
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
    public ArrayList<Task> getCompletedTasksInTimespan(long StartDate, long EndDate) {
        ArrayList<Task> tasks = new ArrayList<>();
        String query = "SELECT JT.`id` FROM JobTasks AS JT WHERE CompletionStaff = " + getId().toString() + " AND CompletionTime BETWEEN '" + new Timestamp(StartDate).toString() + "' AND '" + new Timestamp(EndDate).toString() + "'";
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

    public Boolean hasRolePermissions(Integer RoleID) {
        for (Integer i: _permissions)  {
            if (i.equals(RoleID)) {
                return true;
            }
        }
        return false;
    }

    public Boolean hasRolePermissions(String Role) {
        Integer id = RoleIDs.getOrDefault(Role, 0);
        if (id == 0) {
            throw new RuntimeException("Invalid RoleName " + Role);
        }

        return hasRolePermissions(id);
    }

    public String getUsername() {
        if (UserController.currentUser.getRole() <= 2) {
            return _username;
        }
        return "";
    }

    public String getPassword() {
        if (UserController.currentUser.getRole() <= 2) {
            return _password;
        }
        return "";
    }

    @Override
    public String toString() {
        return "id " + getId().toString() + "\nName " + getName() + "\nDepartment " + getDepartment();
    }
}
