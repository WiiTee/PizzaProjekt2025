import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private int orderID = 0;
    private int customerPhone;
    private LocalTime orderTime;
    private LocalTime pickupTime;
    private ArrayList<Pizza> listPizza;
    private boolean isComplete;
    private static int simpleOrderID = 0;

    public Order(int customerPhone, LocalTime orderTime, LocalTime pickupTime, ArrayList<Pizza> listPizza){
        this.customerPhone = customerPhone;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.listPizza = listPizza;
        this.isComplete = false;
        this.orderID = simpleOrderID;

        simpleOrderID++;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public int getOrderID() {
        return orderID;
    }
    
    public LocalTime getOrderTime() {
        return orderTime;
    }

    public ArrayList<Pizza> getListPizza() {
        return listPizza;
    }

    public void printPizzaList(){
        for(int i = 0; i < listPizza.size(); i++){
            System.out.println(listPizza.get(i).getName() + ": " + listPizza.get(i).getPizzaAmount() + "stk");
        }
    }

    public int compareTo(Order order){
        return getPickupTime().compareTo(order.getPickupTime());
    }
}
