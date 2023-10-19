package devminds.tgcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sgtg?useTimezone=true&serverTimezone=UTC", "root", "root");
        //getConnection().createStatement();
    }
}
