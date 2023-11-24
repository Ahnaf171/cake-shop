import java.util.Scanner;
import java.io.File;
import java.io.IOException; 

public class CakeInfo {
    private String [][] flavoursInfo;
    private float[][] priceInfo;
    private final String flavoursInfoFile = "data/flavours.txt";
    private static final String priceInfoFile = "data/price.txt";

    public CakeInfo() throws IOException {
        flavoursInfo = new String[9][10]; 
        priceInfo = new float[3][3];

        //load flavour information to flavoursInfo
        loadFlavours(flavoursInfoFile);
        //loading price information to priceInfo
        loadPriceInfo(priceInfoFile);
    }

    public void loadFlavours(String flavoursInfoFile) throws IOException {
        // Task 2.1: WRITE YOUR CODE HERE

        // File is used to work on said file. It creates a object of file
        File file = new File(this.flavoursInfoFile);
        String[] firstSplit = new String[2]; // makes an array of length 2
        // created scanner to read file
        Scanner scnr = new Scanner(file);
        // created a 2d array to hold the falvors
        //String[][] flavorStack = new String[9][5]; --- CHECK
        int count = 0;
        
        while(scnr.hasNextLine()){ // reads the file untill the last linne
            
                String line = scnr.nextLine().trim(); // trim to ensure there are no whitespaces
                firstSplit = line.split(":"); // firstSplit seperates the category from the individual flavors
                String flavorLine = firstSplit[1]; 
                //result[c] = secondSplit.split(",");

                this.flavoursInfo[count] = flavorLine.split(","); // flavorLine.split separates each flavor in the list mon each row
                count++;
                // System.out.println();
        }
    }


    public void loadPriceInfo(String priceInfoFile) throws IOException {
        // Task 2.2: WRITE YOUR CODE HERE

        File file = new File(this.priceInfoFile);
        int rows = 3;
        int coloumns = 3;
        // created scanner to read file
         Scanner scnr = new Scanner(file);

        int i = 0;
        while(scnr.hasNextLine()){ // reads file till last line
            String lines = scnr.nextLine().trim(); // trim to remove whitespaces
            String [] layerRow = lines.split(":"); // seperates the layer no. from prices in list
             String [] priceRow = layerRow[1].split(","); // has all the prices in a line
            for(int j = 0; j<priceRow.length;j++){
             String split = priceRow[j]; // seperates each price
             float price = Float.parseFloat(split); // convert to float
             this.priceInfo[i][j] = price; // allocates price to the array
             }
            i++;

        }
     scnr.close();

    }
    /*returns the cake price of a cake*/
    public float calCakePrice(Cake cake) { 
	    // Task 2.3: WRITE YOUR CODE HERE
     int rows = getFlavourCategoryrows(cake); // get the rows to see which column to look in
     int column;

      if(rows == 1 || rows == 2 || rows == 5){
        column= 0;
         }
     else if(rows == 3 || rows == 4 || rows ==7){
        column = 1;
         }
     else {
         column = 2;
         }

        return this.priceInfo[cake.getNoOfLayers()-1][column];
    }


    /*returns the flavour category of the specific cake flavour
    */
    public int getFlavourCategoryrows(Cake cake){  
                                    
        int flavourCatrows = -1; 
	    //specific cake flavour i.e. mint chocolate, red velvet etc..
        String flavour = cake.getFlavour(); 
        for (int i = 0; i < flavoursInfo.length; ++i) {
            int j = 0;

            //loop until the end and until rows is still not found
            while (j < flavoursInfo[i].length && flavourCatrows == -1) {
                if (flavoursInfo[i][j] != null && !flavoursInfo[i][j].isEmpty()) {

		    //found the flavour within each flavour categories (1-9)
                    if (flavour.equals(flavoursInfo[i][j])) {
                        flavourCatrows = i + 1;
                    }
                }
                j += 1;
            }
        }
        
	    //if no flavour is found, flavourCatrows will remain as -1 when it was initialised
        return flavourCatrows; 
    }


    

}