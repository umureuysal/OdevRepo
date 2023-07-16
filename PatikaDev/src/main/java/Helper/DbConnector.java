package Helper;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnector {
    private Connection connect = null;


    public Connection connection(){
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            this.connect = DriverManager.getConnection(Config.DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.connect;
    }

    public static Connection getInstance(){
        DbConnector dbConnector = new DbConnector();
        return dbConnector.connection();
    }
}
