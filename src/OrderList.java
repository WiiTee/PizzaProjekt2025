import java.util.ArrayList;

public class OrderList {
    private ArrayList<Order> listOrder = new ArrayList<>();

    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    public void prioritizedOrders(){
        listOrder.sort(Order::compareTo);
    }
}
