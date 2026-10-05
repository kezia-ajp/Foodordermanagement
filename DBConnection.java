import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {

        Connection c = null;

        try {
            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/food_order_db",
                "root",
                "12345"
            );

            System.out.println("Database Connected");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }
}
