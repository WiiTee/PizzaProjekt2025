import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class OrderHistory {
    private ArrayList<Order> listOrder = new ArrayList<>();


    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void popularPizza() {
    }

    public int revenue() {
        int revenue = 0;
        for (int i = 0; i < getListOrder().size(); i++) {
            revenue += getListOrder().get(i).totalCost();
        }
        return revenue;
    }

    public void showOrderList() {
        System.out.println("ORDER LIST:\n");
        for (Order order : listOrder) {
            System.out.println("Order ID: " + order.getOrderID());
            System.out.println("Phone: " + order.getCustomerPhone());
            System.out.println("Pick up time: " + order.getPickupTime());
            System.out.println("(Order time: " + order.getOrderTime().truncatedTo(ChronoUnit.MINUTES) + ")");
            order.printPizzaList();
            System.out.println("Price: " + order.totalCost() + "KR");
            System.out.println("---------\n");
        }
    }
}
