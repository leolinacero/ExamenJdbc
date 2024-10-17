import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    private static Connection connection;

    static {
        String url = "jdbc:mysql://localhost:3307/ad";
        String user = "root";
        String password = "qwe";
        try{
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        return connection;
    }
}
