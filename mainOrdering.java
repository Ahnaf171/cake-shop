import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.text.DecimalFormat;


public class mainOrdering {
    private static final DecimalFormat format = new DecimalFormat("0.00");

    public static shoppingCart userCart  = new shoppingCart(); // creates an instance of shoppingCart
    static float costTot = 0.00F;
    
    public static Cake cakeOrder() throws IOException{
        final CakeInfo info = new CakeInfo();

        Scanner scnr = new Scanner(System.in);
        String cakeFlavour = "";
        String dietReq = "";
        int numOfLayer = 0;
        int initialCheck =0;
       // float costTot = 0.00F;


        System.out.println("Enter cake flavour: "); // takes flavour input
        cakeFlavour = scnr.nextLine();
    

        System.out.println("Enter number of layer(s): ");
        initialCheck = scnr.nextInt(); // to check if the input is a number between 1 and 3
        scnr.nextLine();
        while(initialCheck>0 || initialCheck<0){ // for all numbers
         if(initialCheck>0 && initialCheck<4){ // to ensure number between 1 and 3
             numOfLayer = initialCheck;
             break;
            
              }
         else if(initialCheck>3 || initialCheck<1){
            initialCheck = 3;
         }
        
        
        }
    

        System.out.println("Enter dietary requirements(Enter NA if there are none): "); // takes dietary requirements
        dietReq = scnr.nextLine();
        
        Cake cakePrice = new Cake(cakeFlavour, numOfLayer, dietReq); // creates the cake 
        float cost = info.calCakePrice(cakePrice);
        cakePrice.setPrice(cost);
        // for(int m = 0; m< userCart.cakeOrder.size();m++){ // shows the price for each cake 
        //      costTot = costTot + cakePrice.getPrice();
        // }
        return cakePrice ;
    }
    
    

    public static void main (String[] args) throws IOException{

        for(; ;){
            System.out.println("");

            System.out.println("Welcome to Cakereations!! \nPlease enter your order using the following commands. \n");
            System.out.println("Enter :\n A- add cake. \n V - view cart. \n R- remove from cart. \n M - See menue \n C- make changes to a cake.\n E- exit and print invoice");

            Scanner scnr = new Scanner(System.in);
            int cakeSequenceNumber = 0;
            String userInput = scnr.nextLine().toUpperCase();// takes first input to start loop
            
            

            while( !userInput.equals("E")){
                userInput = scnr.nextLine().toUpperCase(); 
                
                if(userInput.equals("A")){
                    userCart.addCake(cakeOrder());
                }
                if(userInput.equals("R")){
                    System.out.println("Select cake number to delete");
                    cakeSequenceNumber = scnr.nextInt();
                    userInput = scnr.nextLine(); // to avoid the bug
                    userCart.removeCake(cakeSequenceNumber-1);   
                    
                }
                if(userInput.equals("C")){ //makes ammends
                    System.out.println("Please enter the cake number you want to change");
                    int cakeNum = scnr.nextInt();
                    userCart.ammend(cakeNum);
                    
                }
                if(userInput.equals("M")){
                    userCart.menue();
                }


                if (userInput.equals("V")){ // view cart
                    userCart.viewCart();          
                }
            }
            // asks for candel and add if needed 
            System.out.println("Do you want to add a special candle to your order for $ 10.50?");
            boolean candle = false;
            String CANDLE = scnr.nextLine().toLowerCase();
            
            if(CANDLE.equals("yes")){
                candle = true;
            }
            if(CANDLE.equals("no")){
                candle = false;
            }

            System.out.println("Please enter your adress:");
            String address = scnr.nextLine();
        if(address.length()<8){
            System.out.println("INVALID ADDRESS. The address needs to be at least 10 characters long.");
            System.out.println("Please re-enter a proper address");
            address = scnr.nextLine();
        }
            
            // creats file with the date and time header 
            DateTimeFormatter dateAndTime = DateTimeFormatter.ofPattern("EEE MMMM dd HH.mm.ss");
            LocalDateTime localDateTime = LocalDateTime.now();

            String TXT = dateAndTime.format(localDateTime) + "AEST 2022.txt";
            File file = new File(TXT);
            FileOutputStream fOut = new FileOutputStream(file);
            PrintWriter invoice = new PrintWriter(fOut);

            // start invoice 
            invoice.println("-------------------- Invoice --------------------");

            for(int i = 0; i< userCart.cakeOrder.size(); i++){ // prints cake in order
                invoice.println("Cake " + (i +1) + ": " + userCart.cakeOrder.get(i));
            }
            String candleDecision = "No";

            costTot = userCart.price(); // sets price of total cost by calling methods from shopping cart
            float finalPrice = 0.00f;

            if(candle == true){
                finalPrice = costTot + (float)10.50;
                candleDecision = "Yes";
            }
            else{
                finalPrice = costTot;
            }
            
            invoice.println("Total Cost: $" + format.format(costTot) + " " + "Additional candle: " + candleDecision ); // prints the cost without candle
            invoice.println("Final price: $" + format.format(finalPrice)); // prints final price

            invoice.print("------------------ End Invoice ------------------");
            invoice.println("");


            for(int i = 0; i< userCart.cakeOrder.size(); i++){ 
                
                invoice.println("");
                invoice.println("");
                invoice.println("");


                invoice.println("----------------- Cake Order -----------------");
                invoice.println("");
                invoice.println((userCart.cakeOrder.get(i)));
                invoice.println("");
                invoice.println("---------------------------------------------------");
                
            }

            invoice.flush(); // prints out to file
            invoice.close();

            userCart.cakeOrder.clear();
            costTot = 0.00F;
            finalPrice = 0.00F;
            System.out.println("");
            System.out.println("");
            System.out.println("Welcome to Cakereations!! \nPlease enter your order using the following commands. \n");
            System.out.println("Enter :\n A- add cake. \n V - view cart. \n R- remove from cart. \n C- make changes to a cake.\n E- exit and print invoice");


        }
        
    }



 

}

