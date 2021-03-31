package Report;

import Account.CustomerAccount;
import DB.DBConnWrapper;
import Processing.Controller;
import Processing.Job;
import Processing.Task;
import Users.User;
import Users.UserController;

import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class ShiftRow {
    public String Title;
    public String Date;
    public HashMap<String, Long> LocationTimes;
    public ShiftRow(String date) {
        Date = date;
        LocationTimes = new HashMap<>();
    }
}

public class ReportController {
    public static String savePath = "/Reports/";

    private static ArrayList<String> getLocations() {
        ArrayList<String> locations = new ArrayList<>();
        String query = "SELECT DISTINCT(Location) FROM Task";
        Connection conn = DBConnWrapper.getConnection();
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                locations.add(RS.getString("Location"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    private static String makeUniqueFilename(String Filename, String FileType) {
        Integer id = 1;
        Boolean unique = false;
        while (!unique) {
            unique = false;
            try {FileReader f = new FileReader(Filename+id.toString()+FileType); }
            catch (FileNotFoundException f) {
                unique = true;
            }
            if (unique) {
                return Filename+id.toString()+FileType;
            }
            id+=1;
        }
        return Filename+FileType;
    }

    private static File writeNewReport(String Filename, String body) {
        File reportOut = new File(Filename);
        reportOut.getParentFile().mkdirs();

        try {
            if (reportOut.createNewFile()) {
                FileWriter writer = new FileWriter(Filename);
                writer.write(body);
                writer.close();
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return reportOut;
    }

    public static void createCustomerReport(CustomerAccount c, Instant startTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));

        String ReportStr = "CUSTOMER REPORT SPAN( " + formatter.format(startTime) + " - " + Date.from(Instant.now()).toString() + " )\n"
                + "--- CUSTOMER --- " +  c.toString() + "\n---\n";

        ArrayList<Job> jobs = Controller.getCustomerHistoryInRange(c, startTime.toEpochMilli(), Instant.now().toEpochMilli() );
        for (Job j: jobs) {
            ReportStr = ReportStr + j.toString() + "\n";
        }

        String Prename = savePath + "Customer/CustomerReport" + c.getId().toString() + "_";
        String Filename = makeUniqueFilename(Prename, ".txt");
        File f = writeNewReport(Filename, ReportStr);

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().edit(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createStaffReport(User s, Instant startTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));

        String ReportStr = "STAFF REPORT SPAN( " + formatter.format(startTime) + " - " + formatter.format(Instant.now()) + " )\n"
                + "----- STAFF " + s.getId().toString() + " -----\n"
                + s.toString() + "\n-----\n";

        ArrayList<Task> tasks = s.getCompletedTasksInTimespan(startTime.toEpochMilli(), Instant.now().toEpochMilli());
        for (Task t: tasks) {
            ReportStr = ReportStr + "=== TASK " + t.getId().toString() + " ===\n" + t.toString();
        }

        String Prename = savePath + "Staff/StaffReport" + s.getId().toString() + "_";
        String Filename = makeUniqueFilename(Prename, ".txt");
        File f = writeNewReport(Filename, ReportStr);

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().edit(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createShiftReport() {
        ArrayList<String> locations = getLocations();
        Connection conn = DBConnWrapper.getConnection();

        LocalDateTime current = LocalDateTime.now();
        LocalDateTime startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusDays(7);

        HashMap<LocalDateTime, ShiftRow> Shifts = new HashMap<>();

        try {
            for (long i = 1; i < 8; i++) {
                LocalDateTime shiftStart = startTime.plusDays(i);
                LocalDateTime shiftEnd = shiftStart.plusDays(1);
                Timestamp startStamp = new Timestamp(shiftStart.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())).toEpochMilli());
                Timestamp endStamp = new Timestamp(shiftEnd.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())).toEpochMilli());
                String query = "SELECT * FROM JobTasks INNER JOIN Task ON JobTasks.TaskId = Task.TaskType WHERE StartTime BETWEEN '" + startStamp.toString() + "' AND '" + endStamp.toString() + "' AND Completed = 1";
                ResultSet RS = conn.createStatement().executeQuery(query);
                ShiftRow Shift = new ShiftRow(startStamp.toString());
                System.out.println(query);

                while (RS.next()) {
                    Timestamp taskStart = RS.getTimestamp("StartTime");
                    Timestamp taskEnd = RS.getTimestamp("CompletionTime");
                    String Location = RS.getString("Location");
                    Long elapsed = (taskEnd.getTime() - taskStart.getTime());
                    Long newval = Shift.LocationTimes.getOrDefault(Location, new Long(0)) + elapsed;
                    Shift.LocationTimes.put(Location, newval);
                }
                Shifts.put(shiftStart, Shift);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        String content = "";

        for (HashMap.Entry<LocalDateTime, ShiftRow> entry : Shifts.entrySet()) {
            String top, bottom;
            top = "Date | ";
            LocalDateTime key = entry.getKey();
            bottom = new java.sql.Date(key.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())).toEpochMilli()).toString() + " | ";
            ShiftRow value = entry.getValue();
            for (HashMap.Entry<String, Long> c: value.LocationTimes.entrySet()) {
                String Location = c.getKey();
                Long Duration = c.getValue()/1000;

                top = top + Location;

                Integer hours = (int)(Math.floor(Duration / 3600)%24);
                Integer minutes = (int)(Math.floor(Duration / 60)%60);

                bottom = bottom + hours.toString() + "h:" + minutes.toString() + "m:" + ((Long)(Duration%60)).toString() + "s | ";
                top = top + (" ").repeat( Math.max(1, bottom.length() - top.length() - 3)) + "| ";
            }
            content += top + "\n";
            content += bottom + "\n\n";
        }

        String Prename = savePath + "Shift/ShiftReport";
        String Filename = makeUniqueFilename(Prename, ".txt");
        File f = writeNewReport(Filename, content);

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().edit(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static Integer getAutoDropDownIndex(String s) {
        switch (s) {

            case "MONTHLY":
                return 1;
            case "YEARLY":
                return 2;
            default: //WEEKLY DEFAULTS
                return 0;
        }
    }

    public static void checkAutomatics() {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT * FROM AutoReportRate WHERE id = 1";

        String CustomerRate = "", StaffRate = "", AutoRate = "";


        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                CustomerRate = RS.getString("Customer");
                StaffRate = RS.getString("Staff");
                AutoRate = RS.getString("Shift");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        Timestamp reportTime = Timestamp.from(Instant.now());
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusDays(7);
        Timestamp startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
        query = "SELECT * FROM CustomerAccount WHERE LastReportTime <= '" + startTimestamp.toString() + "'";

        //ASSUME WEEKLY...
        if (CustomerRate == "MONTHLY") {
            startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusMonths(1);
            startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
            query = "SELECT * FROM CustomerAccount WHERE LastReportTime <= '" + startTimestamp.toString() + "'";
        }
        else if (CustomerRate == "YEARLY") {
            startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusYears(1);
            startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
            query = "SELECT * FROM CustomerAccount WHERE LastReportTime <= '" + startTimestamp.toString() + "'";
        }

        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Integer id = RS.getInt("No");
                CustomerAccount c = new CustomerAccount(id);
                ReportController.createCustomerReport(c, startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
                query = "UPDATE CustomerAccount SET LastReportTime = '" + reportTime.toString() + "' WHERE No = " + id.toString();
                conn.createStatement().executeUpdate(query);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        //reset to 7 day check assuming weekly
        startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusDays(7);
        startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
        query = "SELECT * FROM StaffAccount WHERE LastReportTime <= '" + startTimestamp.toString() + "'";

        if (StaffRate == "MONTHLY") {
            startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusMonths(1);
            startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
            query = "SELECT * FROM StaffAccount WHERE LastReportTime <= '" + startTimestamp.toString() + "'";
        }
        else if (StaffRate == "YEARLY") {
            startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusYears(1);
            startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
            query = "SELECT * FROM StaffAccount WHERE LastReportTime <= '" + startTimestamp.toString() + "'";
        }

        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                Integer id = RS.getInt("id");
                User c = new User(id);
                ReportController.createStaffReport(c, startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
                query = "UPDATE StaffAccount SET LastReportTime = '" + reportTime.toString() + "' WHERE id = " + id.toString();
                conn.createStatement().executeUpdate(query);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        query = "DELETE FROM AutoReportRate WHERE id != 1";
        try {
            conn.createStatement().executeUpdate(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        //reset to 7 day check assuming weekly
        startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusDays(7);
        startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
        query = "SELECT COUNT(*) FROM AutoReportRate WHERE LastAutoShiftReport <= '" + startTimestamp.toString() + "'";
        if (AutoRate == "MONTHLY") {
            startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusMonths(1);
            startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
            query = "SELECT COUNT(*) FROM AutoReportRate WHERE LastAutoShiftReport <= '" + startTimestamp.toString() + "'";
        }
        else if (AutoRate  == "YEARLY") {
            startTime = LocalDateTime.of(current.getYear(), current.getMonth(), current.getDayOfMonth(), 0,0,0,0).minusYears(1);
            startTimestamp = Timestamp.from(startTime.toInstant(ZoneId.of("Europe/London").getRules().getOffset(LocalDateTime.now())));
            query = "SELECT COUNT(*) FROM AutoReportRate WHERE LastAutoShiftReport <= '" + startTimestamp.toString() + "'";
        }

        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            while (RS.next()) {
                if (RS.getInt("COUNT(*)") > 0) {
                    createShiftReport();
                    query = "UPDATE AutoReportRate SET LastAutoShiftReport = '" + reportTime.toString() + "' WHERE id = 1";
                    conn.createStatement().executeUpdate(query);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
