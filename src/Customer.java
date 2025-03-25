public class Customer {
    private String customerName;
    private int customerPhoneNumber;
    private boolean customerDiscount;

    public Customer(String customerName, int customerPhoneNumber, boolean customerDiscount) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerDiscount = customerDiscount;
    }

    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
    public boolean getCustomerDiscount() {
        return customerDiscount;
    }

    @Override
    public String toString() {
        return "Customer " + customerName + " with phone number: " + customerPhoneNumber + (customerDiscount ? " gets a discount!" : " doesn't get a discount!");
    }
}


