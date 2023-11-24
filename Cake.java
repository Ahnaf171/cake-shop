import java.text.DecimalFormat;
public class Cake {
    private String flavour;
    private int noOfLayers;
    private float price;
    private String dietaryReq;
    private static final DecimalFormat format = new DecimalFormat("0.00");

    public Cake(String flavour, int noOfLayers, String dietaryReq) {
        
        this.flavour = flavour;
        //cake layers
        this.noOfLayers = noOfLayers; 
        //dietary requirements, customer can say "None"
        this.dietaryReq = dietaryReq; 
	}
    
    public void setFlavour(String flavour){
        this.flavour = flavour;
    }

    public void setNoOfLayers(int noOfLayers){
        this.noOfLayers = noOfLayers;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public void setDietaryReq(String dietaryReq){
        this.dietaryReq = dietaryReq;
    }

    public String toString(){
        // Task 1.1: WRITE YOUR CODE HERE
        

        return "Order: " + getNoOfLayers() + " - layer " + getFlavour() + " cake \t" + "Dietary requirements: " + getDietaryReq() + "\t Cake Price: $" + format.format(price)  ;
    }

    public String getFlavour(){
        return this.flavour;
    }

    public int getNoOfLayers(){
        return this.noOfLayers;
    }

    public float getPrice(){
        return this.price;
    }

    public String getDietaryReq(){
        return this.dietaryReq;
    }
}
