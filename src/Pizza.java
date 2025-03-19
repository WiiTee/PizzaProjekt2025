public class Pizza {
    private int pizzaID;
    private String pizzaName;
    private int pizzaPrice;

    public Pizza(int pizzaID, String pizzaName, int pizzaPrice){
        this.pizzaID = pizzaID;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
    }

    public int getPizzaID() {
        return pizzaID;
    }
    public String getPizzaName() {
        return pizzaName;
    }
    public int getPizzaPrice() {
        return pizzaPrice;
    }
}
