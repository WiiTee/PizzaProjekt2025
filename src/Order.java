import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private int customerPhone;
    private LocalTime orderTime;
    private LocalTime pickupTime;
    private ArrayList<Pizza> listPizza;
    private boolean isComplete;

    public Order(int orderID, int customerPhone, LocalTime orderTime, LocalTime pickupTime, ArrayList<Pizza> listPizza){
        this.orderID = orderID;
        this.customerPhone = customerPhone;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.listPizza = listPizza;
        this.isComplete = false;
    }
}
