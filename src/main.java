import java.time.LocalTime;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        Order order = new Order(1, 12345678, LocalTime.now(), LocalTime.of(11,50), new ArrayList<Pizza>());
        Order order1 = new Order(2, 87654321, LocalTime.now(), LocalTime.of(10, 50), new ArrayList<>());
        Order order2 = new Order(3, 3242, LocalTime.now(), LocalTime.of(13, 50), new ArrayList<>());
        MainMenu menu = new MainMenu();

        OrderList orderList = new OrderList();

        orderList.getListOrder().add(order);
        orderList.getListOrder().add(order1);
        orderList.getListOrder().add(order2);

        for(int i = 0; i < orderList.getListOrder().size(); i++){
            System.out.println(orderList.getListOrder().get(i).getPickupTime());
        }

        orderList.prioritizedOrders();
        orderList.showOrderList();

//        for(int i = 0; i < orderList.getListOrder().size(); i++){
//            System.out.println(orderList.getListOrder().get(i).getPickupTime());
//        }
    }
}
