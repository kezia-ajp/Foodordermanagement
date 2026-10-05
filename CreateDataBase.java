import java.sql.*;

public class CreateDataBase {

    public static void main(String[] args) throws Exception {

        Connection c = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/",
            "root",
            "12345"
        );

        String database =
            "Create database if not exists food_order_db";

        Statement s = c.createStatement();

        s.executeUpdate(database);

        System.out.println("Database Created");
    }
}
