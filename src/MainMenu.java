import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    Order orders;

    /*public MainMenu() {
        orders = new ArrayList<>();
    }*/


    /*public void addOrder(String order) {
        orders.add(order);
    }*/

    public void removeOrder(OrderList orderList) {

        System.out.println("Enter order number you wish to remove");
        int orderIDInput = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < orderList.getListOrder().size(); i++) {
            if (orderList.getListOrder().get(i).getOrderID() == orderIDInput) {
                orderList.getListOrder().remove(i);
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
