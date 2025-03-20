import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);

    private ArrayList<String> orders;

    public MainMenu() {
        orders = new ArrayList<>();
    }

    public void removeOrder() {
        System.out.println("Enter order number you wish to remove");
        int orderIDInput = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < orders.size(); i++) {
            if (orders.getOrderID(i) == orderIDInput) {
                orders.remove(i);
                System.out.println("Order ID: " + orderIDInput + " has been removed from the list");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Couldn't find order ID: " + orderIDInput + " on the list.");
        }
    }
}
