import java.sql.*;
import java.util.Scanner;

public class AllOperations {

    public static final Connection c =
        DBConnection.getConnection();

    static Scanner sc = new Scanner(System.in);

    // Add Food Item
    public static void AddFood() {

        String sql =
            "insert into food_items values(?,?,?)";

        try {

            PreparedStatement ps =
                c.prepareStatement(sql);

            System.out.print("Enter Food ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Food Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);

            ps.executeUpdate();

            System.out.println("Food Item Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // View Menu
    public static void ViewMenu() {

        String sql =
            "select * from food_items";

        try {

            Statement s = c.createStatement();

            ResultSet rs =
                s.executeQuery(sql);

            System.out.println("\n----- MENU -----");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("food_id") + "  " +
                    rs.getString("food_name") + "  Rs." +
                    rs.getDouble("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Add Customer
    public static void AddCustomer() {

        String sql =
            "insert into customers values(?,?,?)";

        try {

            PreparedStatement ps =
                c.prepareStatement(sql);

            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);

            ps.executeUpdate();

            System.out.println("Customer Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Place Order
    public static void PlaceOrder() {

        try {

            ViewMenu();

            System.out.print("\nEnter Customer ID: ");
            int customerId = sc.nextInt();

            System.out.print("Enter Food ID: ");
            int foodId = sc.nextInt();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            String query =
                "select price from food_items where food_id=?";

            PreparedStatement ps1 =
                c.prepareStatement(query);

            ps1.setInt(1, foodId);

            ResultSet rs =
                ps1.executeQuery();

            if (rs.next()) {

                double price =
                    rs.getDouble("price");

                // Calculate total
                double total =
                    price * quantity;

                String sql =
                    "insert into orders" +
                    "(customer_id,food_id,quantity,total)" +
                    " values(?,?,?,?)";

                PreparedStatement ps2 =
                    c.prepareStatement(sql);

                ps2.setInt(1, customerId);
                ps2.setInt(2, foodId);
                ps2.setInt(3, quantity);
                ps2.setDouble(4, total);

                ps2.executeUpdate();

                System.out.println(
                    "Order Placed Successfully"
                );

                System.out.println(
                    "Total Amount = Rs." + total
                );

            } else {

                System.out.println(
                    "Food Item Not Found"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // View Orders
    public static void ViewOrders() {

        String sql =
            "select * from orders";

        try {

            Statement s =
                c.createStatement();

            ResultSet rs =
                s.executeQuery(sql);

            System.out.println("\n----- ORDERS -----");

            while (rs.next()) {

                System.out.println(
                    "Order ID: " +
                    rs.getInt("order_id")
                );

                System.out.println(
                    "Customer ID: " +
                    rs.getInt("customer_id")
                );

                System.out.println(
                    "Food ID: " +
                    rs.getInt("food_id")
                );

                System.out.println(
                    "Quantity: " +
                    rs.getInt("quantity")
                );

                System.out.println(
                    "Total: Rs." +
                    rs.getDouble("total")
                );

                System.out.println("----------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

                
