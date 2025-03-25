import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private int orderID = 0;
    private int customerPhone;
    private LocalTime orderTime;
    private LocalTime pickupTime;
    private ArrayList<Pizza> listPizza;
    private static int simpleOrderID = 0;

    public Order(int customerPhone, LocalTime orderTime, LocalTime pickupTime, ArrayList<Pizza> listPizza){
        this.customerPhone = customerPhone;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.listPizza = listPizza;
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

    public int getCustomerPhone() {
        return customerPhone;
    }

    public ArrayList<Pizza> getListPizza() {
        return listPizza;
    }

    public void printPizzaList(){
        for (Pizza pizza : listPizza) {
            System.out.println(pizza.getName() + ": " + pizza.getPizzaAmount() + "stk");
        }
    }

    public int totalCost(){
        int totalCost = 0;

        for(int i = 0; i < listPizza.size(); i++){
            int price = getListPizza().get(i).getPrice();
            int amount = getListPizza().get(i).getPizzaAmount();

            totalCost += price * amount;
        }


        return totalCost;
    }

    public int compareTo(Order order){
        return getPickupTime().compareTo(order.getPickupTime());
    }
}
