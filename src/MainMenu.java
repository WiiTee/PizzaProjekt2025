import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    Pizza pizzaList = new Pizza();
    int intInput;
    String stringInput;
    boolean isRunning;
    OrderList orderList = new OrderList();
    OrderHistory orderHistory = new OrderHistory();

    public void mainMenu(){
        ArrayList<Pizza> arr2 = new ArrayList<>();
        ArrayList<Pizza> arr3 = new ArrayList<>();

        arr2.add(new Pizza("Test2", 1, 100));

        arr3.add(new Pizza("Shit", 2, 100));

        //Order order = new Order(12345678, LocalTime.now(), LocalTime.of(11,50), arr1);
        Order order1 = new Order(87654321, LocalTime.now(), LocalTime.of(10, 50), arr2);
        Order order2 = new Order(3242, LocalTime.now(), LocalTime.of(13, 50), arr3);

        //orderList.getListOrder().add(order);
        orderList.getListOrder().add(order1);
        orderList.getListOrder().add(order2);

        orderList.prioritizedOrders();

        isRunning = true;
        while(isRunning){
            System.out.println("""
                Please select an option from the ones below, using the numbers 1 - 7
                1. Show list of Pizzas
                2. Add new order
                3. Remove an order
                4. Show list of orders
                5. Update price of pizza
                6. See order history
                7. Quit
                """);
            intInput = inputInt();
            switch (intInput){
                case 1 -> pizzaList.pizzaToString();
                case 2 -> addOrder();
                case 3 -> removeOrder(orderList, orderHistory);
                case 4 -> orderList.showOrderList();
                case 5 -> updatePrice();
                case 6 -> {
                    if(!orderHistory.getListOrder().isEmpty()) {
                        orderHistory.showOrderList();
                        System.out.println("Revenue: " + orderHistory.revenue() + "KR");
                    } else {
                        System.out.println("There's no previous orders!");
                    }
                }
                case 7 -> {
                    System.out.println("See you next time!");
                    isRunning = false;
                }
                default -> System.out.println("Use the numbers to navigate menu");
            }
        }
    }

    public void updatePrice(){
        System.out.println("Enter the pizza number you wish to update the pricing for");
        intInput = inputInt();
        if(pizzaList.getPizzaListe().get(intInput-1).getIDnummer() == intInput){
            System.out.println("Please enter the new price in whole numbers");
            int newPrice = inputInt();
            System.out.println("Are you sure you wish to update " +
                    pizzaList.getPizzaListe().get(intInput-1).getName() +
                    "'s current price of " + pizzaList.getPizzaListe().get(intInput-1).getPrice() +
                    "KR with the new price of " + newPrice + "KR?" + "\n" +
                    "Type Y for yes, N for no");
            stringInput = inputString();
            if(stringInput.equals("Y") || stringInput.equals("y")){
                pizzaList.setPizzaPrice(newPrice, intInput);
                System.out.println("The new price of " + pizzaList.getPizzaListe().get(intInput-1).getName() + " is " + pizzaList.getPizzaListe().get(intInput-1).getPrice() + "KR");
            } else if(stringInput.equals("N") || stringInput.equals("n")){
                System.out.println("Current price has not been changed!");
            } else {
                System.out.println("Try entering Y or N!");
            }
        }
    }

    public void addOrder(){
        boolean choosingPizza = true;

        ArrayList<Pizza> arrList = new ArrayList<>();
        pizzaList.pizzaToString();

        while(choosingPizza) {
            System.out.println("Which Pizza do you want? Choose a number from the pizza list ");
            int pizzaInput = inputInt();
            if (pizzaInput > 0) {
                System.out.println("How many of " + pizzaList.getPizzaListe().get(pizzaInput-1).getName() + " do you want to add?");
                int amountInput = inputInt();

                for(int i = 0; i < pizzaList.getPizzaListe().size(); i++){
                    if(pizzaInput == pizzaList.getPizzaListe().get(i).getIDnummer()){
                        Pizza pizza = new Pizza(pizzaList.getPizzaListe().get(i).getName(), amountInput, pizzaList.getPizzaListe().get(pizzaInput-1).getPrice());
                        arrList.add(pizza);
                        break;
                    }
                }

                System.out.println("Do you want more Pizza's? Choose Y/N");
                stringInput = inputString();
                if(stringInput.equals("N") || stringInput.equals("n")){
                    choosingPizza = false;
                } else { continue; }
            }
            System.out.println("""
                    When do you want to pick up the order?
                    Hour first written as HH
                    """);
            int pickupTimeHour = inputInt();

            System.out.println("""
                    Minutes written as MM
                    """);
            int pickupTimeMinutes = inputInt();

            System.out.println("What is your phone number?");
            int phoneNumber = inputInt();

            Order order = new Order(phoneNumber, LocalTime.now(),LocalTime.of(pickupTimeHour, pickupTimeMinutes), arrList);

            orderList.getListOrder().add(order);
        }
    }

    public void removeOrder(OrderList orderList, OrderHistory orderHistory) {
        orderList.showOrderList();

        System.out.println("Enter order number you wish to remove");
        intInput = inputInt();
        boolean found = false;

        for (int i = 0; i < orderList.getListOrder().size(); i++) {
            if (orderList.getListOrder().get(i).getOrderID() == intInput) {
                orderHistory.getListOrder().add(orderList.getListOrder().get(i));
                orderList.getListOrder().remove(i);
                System.out.println("Order ID: " + intInput + " has been added to order history and removed from the list of orders");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Couldn't find order ID: " + intInput + " on the list.");
        }
    }

    public int inputInt(){
        Scanner scanner = new Scanner(System.in);

        return intInput = scanner.nextInt();
    }

    public String inputString(){
        Scanner scanner = new Scanner(System.in);

        return stringInput = scanner.nextLine();
    }
}
