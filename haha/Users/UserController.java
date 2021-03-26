package Users;

import DB.DBConnWrapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    public static String lastLoginError = "";

    //tested & seems to work...
    static User tryLogIn(String Username, String Password) {
        Connection conn = DBConnWrapper.getConnection();
        String query = "SELECT C.`id`, C.`Password` FROM StaffAccount AS C WHERE C.`Username` = '" + Username + "' AND C.`Password` = '" + Password + "';";
        try {
            ResultSet RS = conn.createStatement().executeQuery(query);
            if (RS.next()) {
                Integer i = RS.getInt("id");
                if (null == i || i < 1) {
                    lastLoginError = "Incorrect Username or Password | Possible SQLError.";
                }
                else
                {
                    lastLoginError = "";
                    return new User(i);
                }
            }
            else
            {
                lastLoginError = "Incorrect Username or Password.";
            }
        }
        catch (SQLException e) {
            lastLoginError = "Known SQLError, check console.";
            e.printStackTrace();
        }
        if (lastLoginError.length() == 0) {
            lastLoginError = "Unknown error";
        }
        return null;
    }
}
