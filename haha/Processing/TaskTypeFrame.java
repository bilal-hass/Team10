package Processing;

public class TaskTypeFrame {
    public String TaskName;
    public String TaskDescription;
    public String Location;
    public Float Price;
    public Integer Duration;//MINUTES
    public Integer Order = 1;
    public Integer TaskType;

    public String getCol(Integer i) {
        switch (i) {
            case 0:
                return TaskName;
            case 1:
                return TaskDescription;
            case 2:
                return Location;
            case 3:
                return Price.toString();
            case 4:
                return Duration.toString();
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return getCol(0);
    }

}
