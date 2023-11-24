import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.*; 
public class flavorsTesting {
    
    public static void main(String args[]) throws IOException{


//         FLAVORS
    String filename = "data/flavours.txt";
    File file = new File(filename);
    int row =5;
    int column =9;
    String [][] values = new String [row][column];
    String[] firstSplit = new String[2];

    Scanner inputStream = new Scanner(file);
    
    String[][] result = new String[9][5];
    int c=0;
    while(inputStream.hasNextLine())
    {
        
            String line = inputStream.nextLine().trim();
            firstSplit = line.split(":");
            String secondSplit = firstSplit[1];
            result[c] = secondSplit.split(",");
            //System.out.println(result[c][0]);
            for(int m=0;m<result[c].length;m++)
                {
                    System.out.println(firstSplit[0]);
                    System.out.println(result[c][m] + " ");
                }
            c++;
            System.out.println();
            //System.out.println(result[c][0]);
    }

    







 }
}