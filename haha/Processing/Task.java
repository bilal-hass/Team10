package Processing;

import DB.DBConnWrapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Task {
    static Map<Integer, String> TaskTypeNameMap = new HashMap<Integer, String>();
    static Map<Integer, String> TaskTypeDescriptionMap = new HashMap<Integer, String>();
    static Map<Integer, String> TaskTypeLocationMap = new HashMap<Integer, String>();
    static Map<Integer, Float> TaskTypePriceMap = new HashMap<Integer, Float>();
    static Map<Integer, Integer> TaskTypeDurationMap = new HashMap<Integer, Integer>();
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
    private Date _startTime;

    public Task(Integer id, Integer type, Integer order, Boolean completed, Date startTime) {
        _id = id;
        _type = type;
        _order = order;
        _completed = completed;
        _name = TaskTypeNameMap.get(type);
        _description = TaskTypeDescriptionMap.get(type);
        _location = TaskTypeLocationMap.get(type);
        _price = TaskTypePriceMap.get(type);
        _durationMinutes = TaskTypeDurationMap.get(type);
        _startTime = startTime;
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
    public Date getStartTime() { return _startTime; }

    public void startTask() {
        _startTime = (java.sql.Date)Date.from(Instant.now());
        UpdateJobTasksSQL("StartTime", _startTime);
    }

    public void completeTask() {
        _completed = true;
        UpdateJobTasksSQL("Completed", _completed);
    }
}
