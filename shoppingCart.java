
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;


public class shoppingCart {
    private final String flavours = "data/flavours.txt";
    private static final DecimalFormat format = new DecimalFormat("0.00");
    public static mainOrdering cake = new mainOrdering(); // creates an instance of order
    Scanner scnr = new Scanner(System.in);
    ArrayList<Cake> cakeOrder; // arraylist named cakeOrder
    public shoppingCart(){
        this.cakeOrder = new ArrayList<Cake>();
    }

    public void addCake(Cake cake){
        cakeOrder.add(cake);
    }
    public void viewCart(){
        for(int i = 0; i< cakeOrder.size(); i++){
            System.out.println("Cake " + (i+1) + ": " + cakeOrder.get(i));
            
        }
        System.out.println("Total cost: $" + format.format(price()));

    }
    public void removeCake(int cakeNumber){
        System.out.println("Confirm delete? Type yes/no");
        if(cakeOrder.isEmpty() == false){
            if(scnr.nextLine().equalsIgnoreCase("yes") == true){
        cakeOrder.remove(cakeNumber);
            }
           
        }

        else{
            System.out.println("Error: No cake to remove. Please enter cake by pressing A");
            //scnr.nextLine();
        }
    
    }
    public void ammend(int elementPlace) throws IOException{
        if(cakeOrder.isEmpty() == false){
        cakeOrder.set(elementPlace-1, cake.cakeOrder());
        }
        else{
            System.out.println("There are no cakes to ammend. Please enter A to add a cake.");
        }
        }

    public float price(){
       float priceTtoal = 0.00F;
       for(int i = 0; i<cakeOrder.size();i++){
       priceTtoal = priceTtoal + cakeOrder.get(i).getPrice();
       }
       return priceTtoal;
    } 
    public void menue() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(this.flavours));
        String line;
        while ((line = br.readLine()) != null) {
      System.out.println(line);
 }

    }
    }
