import java.util.Scanner;

public class Pizza {
    private int IDnummer;
    private String name;
    private int price;

    public Pizza(int IDnummer, String name, int price) {
        this.IDnummer = IDnummer;
        this.name = name;
        this.price = price;
    }

    public int getIDnummer() {
        return IDnummer;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza ID: " + IDnummer + ", Name: " + name + ", Price: " + price + " KR";
    }

    public static void main(String[] args) {

        String[] menu = {"Margherita", "Pepperoni Supreme", "Hawaii Special", "Quattro Formaggi", "Diavola",
                "Capricciosa", "Vegetariana", "BBQ Chicken", "Meat Lovers", "Tropicana",
                "Napolitana", "Tonno e Cipolla", "Parma Delight", "Mexicana", "Gorgonzola Dream",
                "Pesto Passion", "Truffle Temptation", "Spicy Salami", "Buffalo Mozzarella", "Carbonara Pizza",
                "Cheesy Bacon", "Funghi Speciale", "Vesuvio", "Pollo e Pesto", "Bolognese Pizza",
                "Seafood Sensation", "Tartufo Lux", "Chili Inferno", "Mediterranea", "Prosciutto e Rucola"};


        Pizza[] pizzaListe = new Pizza[menu.length];


        for (int i = 0; i < menu.length; i++) {
            int price = 50 + (i * 5);
            pizzaListe[i] = new Pizza(i + 1, menu[i], price);
        }


        System.out.println("Velkommen til Marios Pizzaria! Her er vores menu:🍕");
        for (Pizza pizza : pizzaListe) {
            System.out.println(pizza);
        }


        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIndtast en pizza ID for at vælge en pizza: ");

        if (scanner.hasNextInt()) {
            int valgtID = scanner.nextInt();
            Pizza valgtPizza = findPizzaByID(pizzaListe, valgtID);

            if (valgtPizza != null) {
                System.out.println("Du har valgt: " + valgtPizza);
            } else {
                System.out.println("Pizza med ID " + valgtID + " blev ikke fundet.");
            }
        } else {
            System.out.println("Ugyldigt input. Indtast venligst et tal.");
        }

        scanner.close();
    }


    public static Pizza findPizzaByID(Pizza[] pizzaListe, int id) {
        for (Pizza pizza : pizzaListe) {
            if (pizza.getIDnummer() == id) {
                return pizza;
            }
        }
        return null;
    }
}

