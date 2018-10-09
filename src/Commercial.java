public class Commercial extends  Customer{

// A Commercial class which extends customer that has:
//Property name
//A constant commercial rate at $5 per 1000 square feet (a 10,000 sqft property will be charged $50 dollars per week)
//A multi-property field
//A method that calculates weekly charges, if they have multiple properties provide a 10% discount.
// The method should display all information about the customer, the property, and the weekly charge.


    public Commercial(String customerName, long customerPhone, String customerAddress, Double squareFootage, Boolean senDiscount) {
        super(customerName, customerPhone, customerAddress, squareFootage, senDiscount);
    }


         public void comCalc(){
            double rate = .005; // per square foot
            double senDisc = .010;
            double weekly;
            // call in the information for calculation
            Boolean senDiscount = getSenDiscount();
            Double squareFootage = getSquareFootage();



            if (senDiscount) {
                weekly = (squareFootage * rate) - ((squareFootage * rate)*senDisc);
            } else {
                weekly = (squareFootage * rate);
            }

            super.display(weekly);

        }


    }