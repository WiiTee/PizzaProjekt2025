import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderList {
    private ArrayList<Order> listOrder = new ArrayList<>();

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
            System.out.println("Phone: " + order.getCustomerPhone());
            System.out.println("Pick up time: " + order.getPickupTime());
            System.out.println("(Order time: " + order.getOrderTime().truncatedTo(ChronoUnit.MINUTES) + ")");
            order.printPizzaList();

            double totalPrice;
            if (order.discountAdded()) {
                totalPrice = order.addDiscount();
                System.out.println("10 % discount added.");
            } else {
                totalPrice = order.totalCost();
            }

            System.out.println("Price: " + totalPrice + "KR");
            System.out.println("---------\n");
        }
    }
}
