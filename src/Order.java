import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private int orderID = 0;
    private int customerPhone;
    private LocalTime orderTime;
    private LocalTime pickupTime;
    private ArrayList<Pizza> listPizza;
    private static int simpleOrderID = 0;
    private boolean discountAdded;
    private Customer customer;
    private boolean isDelivered;

    public Order(int customerPhone, LocalTime orderTime, LocalTime pickupTime, ArrayList<Pizza> listPizza, boolean discountAdded, boolean isDelivered){
        this.customerPhone = customerPhone;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.listPizza = listPizza;
        this.orderID = simpleOrderID;
        this.discountAdded = discountAdded;
        this.isDelivered = isDelivered;


        simpleOrderID++;
    }

    public Order(Customer customer, LocalTime orderTime, LocalTime pickupTime, ArrayList<Pizza> listPizza, boolean discountAdded){
        this.customer = customer;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.listPizza = listPizza;
        this.orderID = simpleOrderID;
        this.discountAdded = discountAdded;

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
    public boolean getDiscountAdded() {
        return discountAdded;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Pizza> getListPizza() {
        return listPizza;
    }

    public boolean getIsDelivered() {
        return isDelivered;
    }

    //Printer listen af pizzaer gemt i ordren
    public void printPizzaList(){
        for (Pizza pizza : listPizza) {
            System.out.println(pizza.getPizzaName() + ": " + pizza.getPizzaAmount() + "stk");
        }
    }

    //tilføjer discount
    public double addDiscount() {
        return totalCost() * 0.9;
    }

    //Finder prisen for ordren
    public int totalCost(){
        int totalCost = 0;

        for(int i = 0; i < listPizza.size(); i++){
            int price = getListPizza().get(i).getPizzaPrice();
            int amount = getListPizza().get(i).getPizzaAmount();

            totalCost += price * amount;
        }


        return totalCost;
    }

    //Comparator der tager det forrige objekt og sammenligner med det nuværende.
    public int compareTo(Order order){
        return getPickupTime().compareTo(order.getPickupTime());
    }
}
