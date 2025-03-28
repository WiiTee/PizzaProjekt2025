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
    ArrayList<Customer> customers = new ArrayList<>();

    public void mainMenu(){
        ArrayList<Pizza> arr2 = new ArrayList<>();
        ArrayList<Pizza> arr3 = new ArrayList<>();
        

        arr2.add(new Pizza("Test2", 1, 100));

        arr3.add(new Pizza("Shit", 2, 100));

        //Order order = new Order(12345678, LocalTime.now(), LocalTime.of(11,50), arr1);
        //Order order1 = new Order(87654321, LocalTime.now(), LocalTime.of(10, 50), arr2, true);
        //Order order2 = new Order(3242, LocalTime.now(), LocalTime.of(13, 50), arr3, false);

        //orderList.getListOrder().add(order);
        //orderList.getListOrder().add(order1);
        //orderList.getListOrder().add(order2);

        isRunning = true;
        while(isRunning){

            //Menuen
            System.out.println("""
                Please select an option from the ones below, using the numbers 1 - 7
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

            //Switch case for menuen
            intInput = inputInt();
            switch (intInput){
                case 1 -> pizzaList.printPizzaList();
                case 2 -> addOrder();
                case 3 -> {
                    boolean isComplete = true;
                    removeOrder(orderList, orderHistory, isComplete);
                }
                case 4 -> {
                    boolean isComplete = false;
                    removeOrder(orderList, orderHistory, isComplete);
                }
                case 5 -> {
                    orderList.prioritizedOrders();
                    orderList.showOrderList();
                }
                case 6 -> updatePrice();
                case 7 -> {
                    if(!orderHistory.getListOrder().isEmpty()) {
                        orderHistory.showOrderList();
                        System.out.println("Revenue: " + orderHistory.revenue() + "KR");
                        orderHistory.printPopular();

                    } else {
                        System.out.println("There's no previous orders!");
                    }
                }
                case 8 -> registerCustomer();
                case 9 -> showRegisteredCustomers();
                case 10 -> {
                    System.out.println("See you next time!");
                    isRunning = false;
                }
                default -> System.out.println("Use the numbers to navigate menu");
            }
        }
    }

    //Opdaterer prisen - med lidt sikkerhed så det bliver gjort korrekt)
    public void updatePrice(){
        System.out.println("Enter the pizza number you wish to update the pricing for");
        intInput = inputInt();
        if(pizzaList.getPizzaListe().get(intInput-1).getPizzaID() == intInput){
            System.out.println("Please enter the new price in whole numbers");
            int newPrice = inputInt();
            System.out.println("Are you sure you wish to update " +
                    pizzaList.getPizzaListe().get(intInput-1).getPizzaName() +
                    "'s current price of " + pizzaList.getPizzaListe().get(intInput-1).getPizzaPrice() +
                    "KR with the new price of " + newPrice + "KR?" + "\n" +
                    "Type Y for yes, N for no");
            stringInput = inputString();
            if(stringInput.equals("Y") || stringInput.equals("y")){
                pizzaList.setPizzaPrice(newPrice, intInput);
                System.out.println("The new price of " + pizzaList.getPizzaListe().get(intInput-1).getPizzaName() + " is " + pizzaList.getPizzaListe().get(intInput-1).getPizzaPrice() + "KR");
            } else if(stringInput.equals("N") || stringInput.equals("n")){
                System.out.println("Current price has not been changed!");
            } else {
                System.out.println("Try entering Y or N!");
            }
        }
    }

    //Tilføjer ordren til ordrerlisten.
    public void addOrder(){
        boolean choosingPizza = true;
        boolean pickupHour = true;
        boolean pickupMinute = true;
        int pickupTimeMinutes = 0;
        int pickupTimeHour = 0;
        int phoneNumber;

        ArrayList<Pizza> arrList = new ArrayList<>();
        pizzaList.printPizzaList();

        //While loop til at vælge pizzaer for ordren
        while(choosingPizza) {
            System.out.println("Which Pizza do you want? Choose a number from the pizza list ");
            int pizzaInput = inputInt();

            //Taget et input fra brugeren og vælger pizzaen den vej igennem.
            if (pizzaInput > 0 && pizzaInput <= pizzaList.getPizzaListe().size()) {
                System.out.println("How many of " + pizzaList.getPizzaListe().get(pizzaInput - 1).getPizzaName() + " do you want to add?");
                int amountInput = inputInt();

                //Går menu array igennem og konstruerer en ny pizza objekt til ordren med mængde.
                for (int i = 0; i < pizzaList.getPizzaListe().size(); i++) {
                    if (pizzaInput == pizzaList.getPizzaListe().get(i).getPizzaID()) {
                        Pizza pizza = new Pizza(pizzaList.getPizzaListe().get(i).getPizzaName(), amountInput, pizzaList.getPizzaListe().get(pizzaInput - 1).getPizzaPrice());
                        arrList.add(pizza);
                        break;
                    }
                }

                //Tester om der skal tilføjes flere
                System.out.println("Do you want more Pizza's? Choose Y/N");
                stringInput = inputString();

                if (stringInput.equals("N") || stringInput.equals("n")) {
                    choosingPizza = false;
                }
            } else {
                    System.out.println("That wasn't a number ");
            }
        }

        //Afhentningstidspunkt ud fra inputs
        System.out.println("""
                        When do you want to pick up the order?
                        Hour written as HH
                        """);
        while(pickupHour) {
            pickupTimeHour = inputInt();
            //Tjekker at det er inden for 24 timer
            if (pickupTimeHour < 0 || pickupTimeHour > 23){
                System.out.println("Choose a number within 0 and 23");
            } else {
                pickupHour = false;
            }
        }

        System.out.println("""
                        Minutes written as MM
                        """);
        while (pickupMinute) {
            pickupTimeMinutes = inputInt();
            //Tjekker at det er inden for de 0 og 59
            if(pickupTimeMinutes < 0 || pickupTimeMinutes > 59){
                System.out.println("Pick a number within 0 and 59");
            } else {
                pickupMinute = false;
            }
        }

        //Telefon nummer, tester også om de eksisterer som kunde til at sætte rabat
        System.out.println("What is your phone number?");

        phoneNumber = inputInt();

        Customer matchedCustomer = null;
        for (Customer newCustomer : customers) {
            if (newCustomer.getCustomerPhoneNumber() == phoneNumber) {
                matchedCustomer = newCustomer;
                break;
            }
        }
        boolean hasDiscount = matchedCustomer != null;

        System.out.println("Do you want it delivered? Y/N");
        stringInput = inputString();
        boolean isDelivery = true;
        boolean setDelivery = false;

        while(isDelivery){
            if(stringInput.equalsIgnoreCase("Y")){
                setDelivery = true;
                isDelivery = false;
            } else if (stringInput.equalsIgnoreCase("N")) {
                setDelivery = false;
                isDelivery = false;
            } else {
                System.out.println("Please try Y or N");
            }
        }

        //Opretter ordren
        Order order = new Order(phoneNumber, LocalTime.now(),LocalTime.of(pickupTimeHour, pickupTimeMinutes), arrList, hasDiscount, setDelivery);

        double totalPrice;

        //Laver noget udprint så man hurtigt kan få et overblik over evt. discount og pris
        if (hasDiscount) {
            System.out.println("This customer gets a 10% discount!");
            totalPrice = order.addDiscount();
        } else {
            totalPrice = order.totalCost();
        }

        System.out.println("Total price for this order: " + totalPrice + " kr.");

        //Tilføjer til ordrelisten og prioriterer den
        orderList.getListOrder().add(order);
        orderList.prioritizedOrders();
    }

    //Fjerner/Færdiggøre ordre
    public void removeOrder(OrderList orderList, OrderHistory orderHistory, boolean isComplete) {
        boolean found = false;

        orderList.showOrderList();

        System.out.println("Enter order number you wish to remove");
        intInput = inputInt();

        //Tjekker et array for bruger input
        for (int i = 0; i < orderList.getListOrder().size(); i++) {
            if (orderList.getListOrder().get(i).getOrderID() == intInput) {
                //Hvis den kommer fra Complete menu punktet
                if(isComplete) {
                    //Tilføjer ordren til ordrehistorikken.
                    orderHistory.getListOrder().add(orderList.getListOrder().get(i));
                    System.out.println("Order ID: " + intInput + " has been completed and moved to order history");
                    //Fjerner ordren fra ordrelisten
                    orderList.getListOrder().remove(i);
                    //Kører popular pizzas
                    orderHistory.popularPizza();
                } else {
                    //Hvis den kommer fra Remove menu punktet fjerner den bare ordren.
                    System.out.println("Order ID: " + intInput + " has been removed from order list");
                    orderList.getListOrder().remove(i);
                }
                found = true;
                break;
            }
        }
        //Hvis ikke bruger inputtet matcher
        if (!found) {
            System.out.println("Couldn't find order ID: " + intInput + " on the list.");
        }
    }

    //Registrerer en kunde
    public void registerCustomer() {
        boolean registeringName = true;
        boolean checkingPhoneNumber = true;
        System.out.println("Enter customer name");
        String customerName = "";
        int checkedPhoneNumber = 0;

        //Kører noget while for fejl for kundensnavn
        while(registeringName) {
            customerName = inputString();

            if(customerName.isEmpty()) {
                System.out.println("Please write a name");
            }
            else {
                registeringName = false;
            }
        }

        System.out.println("Enter customer phone number");
        //Kører noget fejltjek for telefon nummer.
        while(checkingPhoneNumber) {
            int customerPhoneNumber = inputInt();
            String testPhoneNumber = String.valueOf(customerPhoneNumber);
            if(testPhoneNumber.length() == 8){
                checkedPhoneNumber = customerPhoneNumber;
                checkingPhoneNumber = false;
            } else {
                System.out.println("The phone number should be 8 digits long");
            }
        }

        //Opretter kunden og tilføjer Dem til kundelisten.
        Customer customer = new Customer(customerName, checkedPhoneNumber);
        System.out.println("Customer added.");

        customers.add(customer);

    }

    //Viser de registrerede kunder
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

    //int input med fejltjek på input
    public int inputInt(){
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()){
            return intInput = scanner.nextInt();
        }
        else {
            System.out.println("Error: Incorrect input");
            return -1;
        }
    }

    public String inputString(){
        Scanner scanner = new Scanner(System.in);

        return stringInput = scanner.nextLine();
    }
}
