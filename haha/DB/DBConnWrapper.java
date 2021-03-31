package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnWrapper {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }

        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost/EMP";

        //  Database credentials
        String USER = "root";
        String PASS = "password1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/cw_db", USER, PASS);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static Integer getMaxId(String table) {
        return getMax(table, "id");
    }

    public static Integer getMax(String table, String column) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT MAX(" + column + ") FROM " + table + ";";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            if (RS.next()) {
                return RS.getInt("MAX("+column+")");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public void close() {
        try { conn.close(); } catch (Exception e) {}
    }
}
