import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;


public class Bestillingsliste {
    public static void main(String[] args) {

        ArrayList<String> Bestillingsliste = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bestillingsliste");

        Bestillingsliste.add("1. Vesuvio");
        Bestillingsliste.add("2. Amerikaner");
        Bestillingsliste.add("3. Cacciatore");
        Bestillingsliste.add("4. Carbona");
        Bestillingsliste.add("5. Dennis");
        Bestillingsliste.add("6. Bertil");
        Bestillingsliste.add("7. Silvia");
        Bestillingsliste.add("8. Victoria");
        Bestillingsliste.add("9. Toronfo");
        Bestillingsliste.add("10. Capricciosa");
        Bestillingsliste.add("11. Hawai");
        Bestillingsliste.add("12. Le blissola");
        Bestillingsliste.add("13. Venezia");
        Bestillingsliste.add("14. Mafia");



        // Choose pizza
        ArrayList<String> order = new ArrayList<>();

        while (true) {
            System.out.print("Write the number of the pizza you want to order: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break; // Exit the loop if the user enters 0
            } else if (choice > 0 && choice <= Bestillingsliste.size()) {
                // Add the pizzas to the order list.
                order.add(Bestillingsliste.get(choice - 1));
                System.out.println(Bestillingsliste.get(choice - 1) + " has been added to your order.");
            } else {
                System.out.println("Error, try again.");
            }
        }

        // Order list total
        System.out.println("Your order:");
        if (order.isEmpty()) {
            System.out.println("Error.");
        } else {
            for (String item : order) {
                System.out.println(item);
            }
        }

        scanner.close();
    }
}













