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



        // Vælg pizzaer
        ArrayList<String> order = new ArrayList<>();

        while (true) {
            System.out.print("Skriv nummer på pizzaen: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break; // Exit the loop if the user enters 0
            } else if (choice > 0 && choice <= Bestillingsliste.size()) {
                // Tilføj pizzaerne til bestillingslisten.
                order.add(Bestillingsliste.get(choice - 1));
                System.out.println(Bestillingsliste.get(choice - 1) + " er tilføjet til din ordre.");
            } else {
                System.out.println("Fejl. Prøv igen.");
            }
        }

        // Bestillingsoversigt
        System.out.println("Din ordre:");
        if (order.isEmpty()) {
            System.out.println("Fejl.");
        } else {
            for (String item : order) {
                System.out.println(item);
            }
        }

        scanner.close();
    }
}













