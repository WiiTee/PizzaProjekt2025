import java.util.ArrayList;

class Pizza {
    private int pizzaID;
    private String pizzaName;
    private int pizzaPrice;
    private int pizzaAmount;
    private ArrayList<Pizza> pizzaListe;

    //Sætter pizza objekter op og tilføjer alle pizzaer til arraylisten der laver menuen
    public Pizza() {
        this.pizzaListe = new ArrayList<>();
        pizzaListe.add(new Pizza(1, "Margherita", 65));
        pizzaListe.add(new Pizza(2, "Pepperoni Supreme", 99));
        pizzaListe.add(new Pizza(3, "Hawaii Special", 89));
        pizzaListe.add(new Pizza(4, "Quattro Formaggi", 50));
        pizzaListe.add(new Pizza(5, "Prosciutto e Rucola", 45));
        pizzaListe.add(new Pizza(6, "Diavola", 78));
        pizzaListe.add(new Pizza(7, "Capricciosa", 69));
        pizzaListe.add(new Pizza(8, "Vegetariana", 120));
        pizzaListe.add(new Pizza(9, "BBQ Chicken", 120));
        pizzaListe.add(new Pizza(10, "Meat Lovers", 89));
        pizzaListe.add(new Pizza(11, "Tropicana", 90));
        pizzaListe.add(new Pizza(12, "Napolitana", 98));
        pizzaListe.add(new Pizza(13, "Tonno e Cipolla", 90));
        pizzaListe.add(new Pizza(14, "Parma Delight", 110));
        pizzaListe.add(new Pizza(15, "Mexicana", 85));
        pizzaListe.add(new Pizza(16, "Gorgonzola Dream", 85));
        pizzaListe.add(new Pizza(17, "Pesto Passion", 120));
        pizzaListe.add(new Pizza(18, "Truffle Temptation", 120));
        pizzaListe.add(new Pizza(19, "Spicy Salami", 55));
        pizzaListe.add(new Pizza(20, "Buffalo Mozzarella", 120));
        pizzaListe.add(new Pizza(21, "Carbonara Pizza", 120));
        pizzaListe.add(new Pizza(22, "Cheesy Bacon", 79));
        pizzaListe.add(new Pizza(23, "Funghi Speciale", 78));
        pizzaListe.add(new Pizza(24, "Vesuvio", 76));
        pizzaListe.add(new Pizza(25, "Pollo e Pesto", 89));
        pizzaListe.add(new Pizza(26, "Bolognese Pizza", 90));
        pizzaListe.add(new Pizza(27, "Seafood Sensation", 79));
        pizzaListe.add(new Pizza(28, "Tartufo Lux", 90));
        pizzaListe.add(new Pizza(29, "Chili Inferno", 79));
        pizzaListe.add(new Pizza(30, "Mediterranea", 89));
    }

    //Konstruktør til at oprette Pizza menu pizzaer
    public Pizza(int pizzaID, String pizzaName, int pizzaPrice) {
        this.pizzaID = pizzaID;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
    }

    //Konstruktør til at oprette Pizza ordrer
    public Pizza(String pizzaName, int pizzaAmount, int pizzaPrice){
        this.pizzaName = pizzaName;
        this.pizzaAmount = pizzaAmount;
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

    public int getPizzaAmount() {
        return pizzaAmount;
    }

    public ArrayList<Pizza> getPizzaListe() {
        return pizzaListe;
    }

    public void setPizzaAmount(int pizzaAmount) {
        this.pizzaAmount = pizzaAmount;
    }

    //Sætter pizza prisen via et index og pris den får passet via parametre
    public void setPizzaPrice(int price, int index) {
        this.pizzaListe.get(index-1).pizzaPrice = price;
    }

    //Printer Pizza listen fra arraylisten.
    public void printPizzaList() {
        for (Pizza pizza : pizzaListe) {
            System.out.println("Nr: " + pizza.pizzaID + ", Name: " + pizza.pizzaName + ", Price: " + pizza.pizzaPrice + " KR");
        }
    }
}