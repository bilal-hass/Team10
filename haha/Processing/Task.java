package Processing;

import DB.DBConnWrapper;
import Users.User;

import java.sql.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Task {
    static Map<Integer, String> TaskTypeNameMap = new HashMap<>();
    static Map<Integer, String> TaskTypeDescriptionMap = new HashMap<>();
    static Map<Integer, String> TaskTypeLocationMap = new HashMap<>();
    static Map<Integer, Float> TaskTypePriceMap = new HashMap<>();
    static Map<Integer, Integer> TaskTypeDurationMap = new HashMap<>();
    //this is kind of scuffed.... but it saves a lot of SQL calls....

    static {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT TaskType as Type, TaskName as Name, TaskDescription as Description, Location, Price, Duration FROM TASK;";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Integer type = RS.getInt("Type");
                String name = RS.getString("Name");
                String description = RS.getString("Description");
                String location = RS.getString("Location");
                Float price = RS.getFloat("Price");
                Integer duration = RS.getInt("Duration");

                TaskTypeNameMap.put(type, name);
                TaskTypeDescriptionMap.put(type, description);
                TaskTypeLocationMap.put(type, location);
                TaskTypePriceMap.put(type, price);
                TaskTypeDurationMap.put(type, duration);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Integer _type;
    private Integer _order;
    private Integer _id;
    private Boolean _completed;
    private String _name;
    private String _description;
    private String _location;
    private Float _price;
    private Integer _durationMinutes;
    private Timestamp _startTime;
    private Timestamp _endTime;
    private User _completionStaff;

    public Task(Integer id) {
        _id = id;

        if (getTaskCount(id).intValue() == 0) {
            throw new RuntimeException("Task.new bad id, no SQL entry found, please use Controller.createNewTask");
        }

        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT `Order`, `StartTime`, `TaskId` AS TaskType, `JobId`, `Completed`, `CompletionStaff`, `CompletionTime` FROM JobTasks\n"
                + "WHERE `id` = " + id.toString() + ";";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                _order = RS.getInt("Order");
                _type = RS.getInt("TaskType");
                _completed = RS.getBoolean("Completed");


                _name = TaskTypeNameMap.get(_type);
                _description = TaskTypeDescriptionMap.get(_type);
                _location = TaskTypeLocationMap.get(_type);
                _endTime = RS.getTimestamp("CompletionTime");
                _price = TaskTypePriceMap.get(_type);
                _durationMinutes = TaskTypeDurationMap.get(_type);
                _startTime = RS.getTimestamp("StartTime");
                if (RS.getInt("CompletionStaff") > 0) {
                    _completionStaff = new User(RS.getInt("CompletionStaff"));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }


    }

    private Integer getTaskCount(Integer id) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT COUNT(*) FROM JobTasks WHERE id = " + id.toString() + ";";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            if (RS.next()) { return RS.getInt("COUNT(*)"); }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void UpdateJobTasksSQL(String Column, Object Value) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "UPDATE JobTasks \n SET " + Column + " = " + Value.toString() + " \n WHERE id = " + _id.toString() + ";";
        try {
            Integer affected = conn.createStatement().executeUpdate(query);
            if (affected < 1) {
                throw new RuntimeException("Failed to update JobTask " + _id.toString() + " column " + Column);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() { return _id; }
    public Integer getType() { return _type; }
    public Integer getOrder() { return _order; }
    public Boolean getCompleted() { return _completed; }
    public String getName() { return _name; }
    public String getDescription() { return _description; }
    public String getLocation() { return _location; }
    public Float getPrice() { return _price; }
    public Integer getDurationMinutes() { return _durationMinutes; }
    public Timestamp getStartTime() { return _startTime; }

    public void startTask() {
        _startTime = java.sql.Timestamp.from(Instant.now());
        UpdateJobTasksSQL("StartTime", "'"+_startTime.toString()+"'");
    }

    public void completeTask(User completedBy) {
        //TODO: add StaffMember Id for complete task.
        _completed = true;
        _completionStaff = completedBy;
        UpdateJobTasksSQL("Completed", true);
        UpdateJobTasksSQL("CompletionStaff", completedBy.getId());
        UpdateJobTasksSQL("CompletionTime", "'"+java.sql.Timestamp.from(Instant.now())+"'" );
    }

    public Boolean started() {
        if (_startTime == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public Timestamp getEndTime() {
        return _endTime;
    }

    public User getCompletionStaff() {
        return _completionStaff;
    }

    @Override
    public String toString() {
        String str = "id " + getId().toString() + "\n"
                + "Type " + getName() + "\n"
                + "Price £" + getPrice().toString() + "\n"
                + "Location " + getLocation() + "\n"
                + "StartTime " + getStartTime().toString() + "\n"
                + "CompletionTime " + getEndTime().toString() + "\n"
                + "CompletionStaff " + getCompletionStaff().getId() + "\n";
        return str;
    }
}
