import java.text.DecimalFormat;

public class Customer {
    /***
     *  NO additional parameters within the customer class.  The customer class is being used
     *  to print out information collected from the main class and calculated from the residential class
    A Customer class that has:
    String customerFName
    String customerPhone
    String customerAddress
    double squareFootage
     */

    //    private String customerFName;  I messed up trying to be creative.   I think defining a residential First Name and last name and only a business
    //Name was creating issues with the inheritance.  My bad.
    private String customerName;
    private long customerPhone;
    private String customerAddress;
    private Double squareFootage;
    private Boolean senDiscount;

    public Customer(String customerName, long customerPhone, String customerAddress,Double squareFootage, Boolean senDiscount){
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.squareFootage = squareFootage;
        this.senDiscount = senDiscount;
    }

    void display(double weekly){
        /***
         * The output of the weekly customer information
         *
         *
         */

        DecimalFormat df = new DecimalFormat("#.##");
        String weeklyformat = df.format(weekly);

        System.out.println("------------------------Customer Information------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-------------------------CLIENT INFORMATION-------------------------------------");
//        System.out.println(getCustomerFName());
        System.out.println(getCustomerName());
        System.out.println(getCustomerAddress());
        System.out.println(getCustomerPhone());
        System.out.println("---------------------------------------------------------------");
        System.out.println("--------------------Lawn Information---------------------------");
        System.out.println("Square Footage: " + getSquareFootage());
        System.out.println("Multi Business Discount: " + getSenDiscount());
        System.out.printf("Weekly Total for Lawn Care and Maintenance: $" + weeklyformat);
        System.out.println("\n---------------------------------------------------------------");
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(long customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(Double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public Boolean getSenDiscount() {
        return senDiscount;
    }

    public void setSenDiscount(Boolean senDiscount) {
        this.senDiscount = senDiscount;
    }
}
