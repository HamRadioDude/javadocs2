import java.util.Scanner;

public class Main {

    /***
     *
     *
     * Nothing parameter wise within this part of the main
     *
     * @param args

     *  The Main class that presents a menu to the user with the following options:
     *  Residential Customer
     * Commercial Customer
        * Done

     * The Main class should have methods that get data entry from the user about the
     * Residential or Commercial customer and should display all of the information in the
     * form of a quote.
     */

    public static void main(String[] args) {
        /***
         *
         *
         *  Define user input and make a menu to determine residential or commercial customers/clients.
         *  1. for residential client
         *  2. for commercial client
         *  3.  for exit
         *
         * @param input is used for system input (scanner)
         * @param mainSelect is used for the user selection in the main menu
         *
         */


        Scanner input = new Scanner(System.in);  // used for user input
        int mainSelect = 0; // the main screen user selection (integer value)

        do {  // Create a user friendly menu

            System.out.print("----------------Slick Rick's Lawn Services-----------------------\n");
            System.out.print("---------Employee Access Only - Others Unauthorized--------------\n");
            System.out.print("-------------Select the type of client below:--------------------\n");
            System.out.print("1. Residential\n");
            System.out.print("2. Commercial\n");
            System.out.print("3. Quit\n");
//            mainSelect = input.nextInt();

            try {
                mainSelect = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                input.nextInt();
            }
        } while (mainSelect != 1 && mainSelect != 2 && mainSelect != 3);
        {
            input.nextLine();
        }
        if (mainSelect == 1) {
            residential();

        } else if (mainSelect == 2) {
            commercial();
        } else {
            System.exit(0);
        }

    }








        private static void residential () {
            /***
             *
             * Get customer information (Residential
             * @param input - scanner
             * @param senDiscount - boolean - used to confirm senior discount
             * @param chkDiscount - converted sen Discount to confirm/compare  true or false.    (y or n)
             * @param customerName - String used for customer's Name
             * @param customerAddress - String used for customer address
             * @param customerPhone - Long - a 10 digit phone number for the customer
             * @param squareFootage = Double - Double used to collect square footage. Initially, i wanted it to be
             *                      an integer, but i guess its possible for someone to be so honest that they use
             *                      "100.5 sqft" instead of 101 sqft or 100 sq ft.
             *
             *
             *
             *
             * A residential class which extends customer that has:
            *  A constant rate at $6 per 1000 square feet
            *  A senior field
            *  A method that calculates weekly charges, if the senior field is set to true then provide a 15% discount.
            *  The method should display all information about the customer, the property, and the weekly charge.
             *
             */


            // VARIABLES LISTED HERE:
            Scanner input = new Scanner(System.in);  // used for user input
            boolean senDiscount;
            String chkDiscount;
            boolean custnamck = true;
            String customerName ="";
            String customerAddress = "";
            long customerPhone = 0;
            double squareFootage = 0;

            // Collect input to be used in other Classes.  Customer Last Name, Customer First Name, customerAddress, Phone, Senior, property size
//            System.out.println("Enter The Customer's First Name: ");
//            String customerFName = input.nextLine();
            do {
                System.out.println("Enter The Customer's Name: ");
                try {
                    customerName = input.nextLine();
                    if (customerName.length() < 20) { // Would have done 50, but for testing purposes, it's easier to make it 0
                        custnamck = true;
                    } else {
                        System.out.println("The last name was not accepted due to an overly large amount of letters, please limit it to less than 20");
                        custnamck = false;
                    }
                } catch (java.util.InputMismatchException a) {
                    System.out.println("Name Error, name must be less than 20 characters"); // again, 50 would have  probably been the limit
                }
            } while (!custnamck);
            do {
                System.out.println("Enter The Customer's Address: ");
                try {
                    customerAddress = input.nextLine();
                    if (customerAddress.length() < 20) {
                        custnamck = true;
                    } else {
                        custnamck = false;
                        System.out.println("Address Cannot be great than 20 digits, try again");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("ADDRESS ERROR - Must be less than 20 digits");
                }
            } while (!custnamck);

            do {
                System.out.println("Enter the Customer Phone Number: ");
                try {
                    customerPhone = input.nextLong();
                    String stringCustPH = Long.toString(customerPhone);
//                if (customerPhone.length())  doesnt work on long. also tried customerPhone.length(10), thinking that would define the max length
                    if (stringCustPH.length() == 10) {
                        custnamck = true;
                    } else {
                        custnamck = false;
                        System.out.println("Invalid phone number.  Must be 10 digits and NUMBERS ONLY");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error in Phone Number, - 10 numeric digits were required");
                }
            }while (!custnamck);
                do {
                    System.out.println("What is the square footage of the property? ");
                    try {
                        squareFootage = input.nextDouble();
                        if (squareFootage > -1) {
                            custnamck = true;
                        } else {
                            custnamck = false;
                            System.out.println("Invalid Square Footage");
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Error in square Footage.  number was less than 0");
                    }
                }while (!custnamck);



                        // The discount doesn't work 10/17/2018.  Just skips over this option.  NEED TO EVALUATE @1953 HOURS SK
                        // SK100718 @ 2204 - Corrected by making input.next as opposed to input.nextLine();
                        System.out.println("Does the Residential Client qualify for a Senior discount (55 years or older) ? Y or y if Yes.  Anything else will default to No discount ");
                        chkDiscount = input.next();
                        if (chkDiscount.equalsIgnoreCase("y")) {
                            senDiscount = true;
                        } else {
                            senDiscount = false;
                        }


                    // Information will now be sent to Residential class - resCalc method.

                    Residential customer = new Residential(customerName, customerPhone, customerAddress, squareFootage, senDiscount);
                    //variables set to Residential()
                    customer.resCalc();

                    //
                }




        private static void commercial () {

            /***
             *
             * Get customer information (Business)
             * @param input - scanner
             * @param senDiscount - boolean - used to confirm additional properties
             * @param chkDiscount - converted senDiscount to confirm/compare  true or false.    (y or n)
             * @param customerName - String used for Business Name
             * @param customerAddress - String used for customer address
             * @param customerPhone - Long - a 10 digit phone number for the customer
             * @param squareFootage = Double - Double used to collect square footage. Initially, i wanted it to be
             *                      an integer, but i guess its possible for someone to be so honest that they use
             *                      "100.5 sqft" instead of 101 sqft or 100 sq ft.
             *
             *
             *
             *
             * A Business class which extends customer that has:
             *  A constant rate at $5 per 1000 square feet
             *  A 10 percent discount for businesses with multiple properties

             */

            Scanner input = new Scanner(System.in);  // used for user input
            boolean senDiscount;
            String chkDiscount;
            boolean custnamck = true;
            String customerName ="";
            String customerAddress = "";
            long customerPhone = 0;
            double squareFootage = 0;

            do {
                System.out.println("Enter The Business Name: ");
                try {
                    customerName = input.nextLine();
                    if (customerName.length() < 20) { // Would have done 50, but for testing purposes, it's easier to make it 0
                        custnamck = true;
                    } else {
                        System.out.println("The last name was not accepted due to an overly large amount of letters, please limit it to less than 20");
                        custnamck = false;
                    }
                } catch (java.util.InputMismatchException a) {
                    System.out.println("Name Error, name must be less than 20 characters"); // again, 50 would have  probably been the limit
                }
            } while (!custnamck);
            do {
                System.out.println("Enter The Business Address: ");
                try {
                    customerAddress = input.nextLine();
                    if (customerAddress.length() < 20) {
                        custnamck = true;
                    } else {
                        custnamck = false;
                        System.out.println("Address Cannot be great than 20 digits, try again");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("ADDRESS ERROR - Must be less than 20 digits");
                }
            } while (!custnamck);

            do {
                System.out.println("Enter the Business Phone Number: ");
                try {
                    customerPhone = input.nextLong();
                    String stringCustPH = Long.toString(customerPhone);
//                if (customerPhone.length())  doesnt work on long. also tried customerPhone.length(10), thinking that would define the max length
                    if (stringCustPH.length() == 10) {
                        custnamck = true;
                    } else {
                        custnamck = false;
                        System.out.println("Invalid phone number.  Must be 10 digits and NUMBERS ONLY");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error in Phone Number, - 10 numeric digits were required");
                }
            }while (!custnamck);
            do {
                System.out.println("What is the square footage of the property? ");
                try {
                    squareFootage = input.nextDouble();
                    if (squareFootage > -1) {
                        custnamck = true;
                    } else {
                        custnamck = false;
                        System.out.println("Invalid Square Footage");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Error in square Footage.  number was less than 0");
                }
            }while (!custnamck);



            // The discount doesn't work 10/17/2018.  Just skips over this option.  NEED TO EVALUATE @1953 HOURS SK
            // SK100718 @ 2204 - Corrected by making input.next as opposed to input.nextLine();
            System.out.println("Is there more more than one Business property using Slick Rick's Lawn Services?  Y or y if Yes.  Anything else will default to No discount ");
            chkDiscount = input.next();
            if (chkDiscount.equalsIgnoreCase("y")) {
                senDiscount = true;
            } else {
                senDiscount = false;
            }





            // Information will now be sent to Commercial class - comCalc method.

            Commercial customer = new Commercial(customerName, customerPhone, customerAddress, squareFootage, senDiscount); // SENDISCOUNT IS A STUPID NAME, DISCOUNT WOULD BE FINE
            //variables set to Residential()
            customer.comCalc();

            //


        }
    }
