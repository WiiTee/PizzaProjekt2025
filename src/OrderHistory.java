import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;

public class OrderHistory {
    private ArrayList<Order> listOrder = new ArrayList<>();
    private ArrayList<Pizza> popularPizza = new ArrayList<>();


    public ArrayList<Order> getListOrder() {
        return listOrder;
    }

    //Smider pizza fra ordrerlisten over i et array til populære pizzaer
    public void popularPizza() {
        //looper igennem ordrerhistorik arrayet
        for(int i = 0; i < listOrder.size(); i++){
            //looper igennem hver enkelt ordrer's pizza array
            for(int z = 0; z < listOrder.get(i).getListPizza().size(); z++){
                //Hvis popularPizza array er tomt tilføjes den første Pizza til array
                if(popularPizza.isEmpty()){
                    popularPizza.add(listOrder.get(i).getListPizza().get(z));
                } else {
                    //Looper igennem popularPizza arrayet
                    for (int x = 0; x < popularPizza.size(); x++)
                        //Hvis ordrerhistorik pizzaen's navn er det samme som popular pizza
                        if (listOrder.get(i).getListPizza().get(z).getPizzaName().equals(popularPizza.get(x).getPizzaName())) {
                            //Sæt amount lig med amount hentet fra Popular Pizzas
                            int amount = popularPizza.get(x).getPizzaAmount();
                            //Læg Pizza mængden fra ordren oven til amount.
                            amount += listOrder.get(i).getListPizza().get(z).getPizzaAmount();

                            //Sæt popular Pizza amount
                            popularPizza.get(x).setPizzaAmount(amount);
                        } else {
                            //Ellers tilføj pizzaen fra ordrehistorikken
                            popularPizza.add(listOrder.get(i).getListPizza().get(z));
                        }
                }
            }
        }
        //Sorterer popular pizzas via en comparator der sammenligner Int fra Pizza klassen amount og sætter den omvendt rækkefølge
        popularPizza.sort(Comparator.comparingInt(Pizza::getPizzaAmount).reversed());
    }

    //Printer den populære pizza liste ud.
    public void printPopular(){
        System.out.println("Most popular pizza's!" + "\n" +
                           "---------------------");
        for(int i = 0; i < popularPizza.size(); i++){
            System.out.println("Pizza name: " + popularPizza.get(i).getPizzaName() + "\n" +
                               "Amount: " + popularPizza.get(i).getPizzaAmount() + "\n" +
                               "---------------------" );
        }
    }

    //Henter indkomsten fra ordrerlisten
    public int revenue() {
        int revenue = 0;
        for (int i = 0; i < getListOrder().size(); i++) {
            revenue += getListOrder().get(i).totalCost();
        }
        return revenue;
    }

    //Viser ordrer i en ordnet liste
    public void showOrderList() {
        double totalPrice;
        System.out.println("ORDER HISTORY:\n");
        for (Order order : listOrder) {

            //ID
            System.out.println("Order ID: " + order.getOrderID());
            //Telefon
            System.out.println("Phone: " + order.getCustomerPhone());
            //Afhentningstid
            System.out.println("Pick up time: " + order.getPickupTime());
            //Ordrertid - truncated for at fjerne nanosekunder, sekunder.
            System.out.println("(Order time: " + order.getOrderTime().truncatedTo(ChronoUnit.MINUTES) + ")");
            //Henter listen af pizzaer
            order.printPizzaList();
            //Tilføjer discount
            if (order.getDiscountAdded()) {
                totalPrice = order.addDiscount();
                System.out.println("10 % discount added.");
            } else {
                totalPrice = order.totalCost();
            }
            //Printer den totale pris
            System.out.println("Price: " + totalPrice + "KR");
            System.out.println("---------\n");
        }
    }
}
