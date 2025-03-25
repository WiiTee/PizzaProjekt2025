import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    Pizza pizzaList = new Pizza();
    int intInput;
    String stringInput;
    boolean isRunning;
    OrderList orderList = new OrderList();

    public void mainMenu(){
        ArrayList<Pizza> arr1 = new ArrayList<>();
        ArrayList<Pizza> arr2 = new ArrayList<>();
        ArrayList<Pizza> arr3 = new ArrayList<>();

        arr1.add(new Pizza("Margerita", 4, 65));
        arr1.add(new Pizza("Vesuvio", 2, 100));
        arr1.add(new Pizza("Diavola", 1, 150));

        arr2.add(new Pizza("Test2", 1, 100));

        arr3.add(new Pizza("Shit", 2, 100));

        Order order = new Order(12345678, LocalTime.now(), LocalTime.of(11,50), arr1);
        Order order1 = new Order(87654321, LocalTime.now(), LocalTime.of(10, 50), arr2);
        Order order2 = new Order(3242, LocalTime.now(), LocalTime.of(13, 50), arr3);

        OrderList orderList = new OrderList();

        orderList.getListOrder().add(order);
        orderList.getListOrder().add(order1);
        orderList.getListOrder().add(order2);

        orderList.prioritizedOrders();

        isRunning = true;
        while(isRunning){
            System.out.println("""
                Please select an option from the ones below, using the numbers 1 - X
                1. Show list of Pizzas
                2. Add new order
                3. Complete an order
                4. Remove an order
                5. Show list of orders
                6. Update price of pizza
                7. See order history
                8. Register customer
                9. Show registered customers
                10. Quit
                """);

            intInput = inputInt();
            switch (intInput){
                case 1 -> pizzaList.pizzaToString();
                case 2 -> System.out.println("Not done yet!");
                case 3 -> System.out.println("Not done yet!");
                case 4 -> removeOrder(orderList);
                case 5 -> orderList.showOrderList();
                case 6 -> updatePrice();
                case 7 -> System.out.println("Not done either!");
                case 8 -> registerCustomer();
                case 9 -> showRegisteredCustomers();
                case 10 -> {
                    System.out.println("Oh cool, just leave me why not...");
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

    public void removeOrder(OrderList orderList) {
        orderList.showOrderList();

        System.out.println("Enter order number you wish to remove");
        intInput = inputInt();
        boolean found = false;

        for (int i = 0; i < orderList.getListOrder().size(); i++) {
            if (orderList.getListOrder().get(i).getOrderID() == intInput) {
                orderList.getListOrder().remove(i);
                System.out.println("Order ID: " + intInput + " has been removed from the list");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Couldn't find order ID: " + intInput + " on the list.");
        }
    }

    ArrayList<Customer> customers = new ArrayList<>();

    public void registerCustomer() {
        System.out.println("Enter customer name");
        String customerName = inputString();

        System.out.println("Enter customer phone number");
        int customerPhoneNumber = inputInt();

        System.out.println("Does the customer get a discount?" + "\n" +
                "Type Y for yes, N for no");
        String discountInput = inputString();
        boolean customerDiscount;

        if (discountInput.equalsIgnoreCase("y")) {
            customerDiscount = true;
        } else {
            customerDiscount = false;
        }
        customers.add(new Customer(customerName, customerPhoneNumber, customerDiscount));
        System.out.println("Customer added.");

    }

    public void showRegisteredCustomers() {
        if (customers.isEmpty()) {
            System.out.println("You have no registered customers.");
        } else {
            System.out.println("Registered customers:");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }

    }

    public int inputInt(){
        Scanner scanner = new Scanner(System.in);
        int intInput;

        return intInput = scanner.nextInt();
    }

    public String inputString(){
        Scanner scanner = new Scanner(System.in);
        String stringInput;

        return stringInput = scanner.nextLine();
    }
}
