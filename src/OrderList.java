import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrderList {
    private ArrayList<Order> listOrder = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void prioritizedOrders(){
        listOrder.sort(Order::compareTo);
    }

    public void showOrderList(){
        System.out.println("ORDER LIST:\n");
        for (Order order : listOrder) {
            System.out.println("Order ID: " + order.getOrderID());
            System.out.println("Pick up time: " + order.getPickupTime());
            System.out.println("(Order time: " + order.getOrderTime() + ")");
            System.out.println("---------\n");
        }
    }
}
