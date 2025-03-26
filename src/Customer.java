import java.util.ArrayList;

public class Customer {
    private String customerName;
    private int customerPhoneNumber;

   private ArrayList<Customer> customers = new ArrayList<>();

    public Customer(String customerName, int customerPhoneNumber) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }


    @Override
    public String toString() {
        return "Customer " + customerName + " with phone number: " + customerPhoneNumber;
    }
}


