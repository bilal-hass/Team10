package Processing;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Discount.DiscountController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
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

        return new Job(jobId, c);
    }
}
