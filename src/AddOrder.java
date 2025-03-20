import java.util.ArrayList;
import java.util.Scanner;

public class AddOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList bestillingsListe = new ArrayList<String>();
        addToOrderList(bestillingsListe, scanner);
    }

    public static void addToOrderList(ArrayList<String> bestillingsListe, Scanner scanner) {
        System.out.println("Add new order:");
        String newOrder = scanner.nextLine();
        bestillingsListe.add(newOrder);
        System.out.println(newOrder + " has been added to order.");
    }
}
