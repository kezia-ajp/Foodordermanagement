import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println(
                "\n===== FOOD ORDER MANAGEMENT SYSTEM ====="
            );

            System.out.println("1. Add Food Item");
            System.out.println("2. View Menu");
            System.out.println("3. Add Customer");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    AllOperations.AddFood();
                    break;

                case 2:
                    AllOperations.ViewMenu();
                    break;

                case 3:
                    AllOperations.AddCustomer();
                    break;

                case 4:
                    AllOperations.PlaceOrder();
                    break;

                case 5:
                    AllOperations.ViewOrders();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
