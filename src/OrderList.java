import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class OrderList {
    private ArrayList<Order> listOrder = new ArrayList<>();

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void prioritizedOrders(){
        listOrder.sort(Order::compareTo);
    }
}
