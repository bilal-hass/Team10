package newProcessing;

import Controller.DatabaseConnection;

import java.util.ArrayList;

public class TaskTypeCollection {

    ArrayList<TaskType> taskTypes;
    DatabaseConnection databaseConnection;

    void addTaskType() {
        TaskType taskType = new TaskType();
        taskType.setName("");
        taskType.setDescription("");
        taskType.setDepartment("");
        taskType.setDuration(0);
        taskType.setPrice(0);
        taskTypes.add(taskType);
        databaseConnection.query(
                "INSERT INTO TaskType " +
                String.format(
                        "%s, %s, %s, %d, %f",
                        taskType.getName(), taskType.getDescription(), taskType.getDepartment(), taskType.getDuration(), taskType.getPrice()
                )
        );
    }

    void removeTaskType() {
        // need to select task on gui
        TaskType taskType = new TaskType();
        databaseConnection.query(
                "DELETE * FROM TaskType WHERE name = " + taskType.getName()
        );
        taskTypes.remove(taskType);
    }

    void traverseTaskTypes() {
        for (TaskType taskType : taskTypes) {
            // display on gui
            System.out.println(taskType.getDescription());
        }
    }

    public TaskTypeCollection() {
        databaseConnection = new DatabaseConnection();
    }
}
