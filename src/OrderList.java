import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderList {
    private ArrayList<Order> listOrder = new ArrayList<>();

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    //Sorterer ordrer efter en Comparator i ordrer menu.
    public void prioritizedOrders(){
        listOrder.sort(Order::compareTo);
    }

    //Viser listen af ordrer
    public void showOrderList(){
        double totalPrice;
        System.out.println("ORDER LIST:\n");
        for (Order order : listOrder) {
            System.out.println("Order ID: " + order.getOrderID());
            System.out.println("Phone: " + order.getCustomerPhone());
            System.out.println("Pick up time: " + order.getPickupTime());
            System.out.println("(Order time: " + order.getOrderTime().truncatedTo(ChronoUnit.MINUTES) + ")");
            order.printPizzaList();

            //Vælger mellem discount og ingen discount
            if (order.getDiscountAdded()) {
                totalPrice = order.addDiscount();
                System.out.println("10 % discount added.");
            } else {
                totalPrice = order.totalCost();
            }
            System.out.println("Price: " + totalPrice + "KR");

            if(order.getIsDelivered()){
                System.out.println("Delivery: " + "✅");
            } else {
                System.out.println("Delivery: " + "❌");
            }
            System.out.println("---------\n");
        }
    }
}
