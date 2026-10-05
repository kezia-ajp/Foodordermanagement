import java.sql.*;

public class CreateTable {

    public static void main(String[] args) throws Exception {

        Connection c = DBConnection.getConnection();

        String food = """
        Create table if not exists food_items(
            food_id int primary key,
            food_name varchar(50),
            price double
        )
        """;

        String customer = """
        Create table if not exists customers(
            customer_id int primary key,
            customer_name varchar(50),
            phone varchar(15)
        )
        """;

        String orders = """
        Create table if not exists orders(
            order_id int primary key auto_increment,
            customer_id int,
            food_id int,
            quantity int,
            total double,
            order_date timestamp default current_timestamp
        )
        """;

        Statement s = c.createStatement();

        s.executeUpdate(food);
        s.executeUpdate(customer);
        s.executeUpdate(orders);

        System.out.println("Tables Created");
    }
}
