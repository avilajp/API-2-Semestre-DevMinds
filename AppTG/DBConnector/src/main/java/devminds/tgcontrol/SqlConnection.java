package devminds.tgcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sgtg", "root", "root");
    }
}
