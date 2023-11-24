import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class priceTest{
    public static void main(String[] args) throws IOException
    {
        String filename = "data/price.txt";
        File file = new File(filename);
        int row =3;
        int column =3;
        String [][] values = new String [row][column];
        List<String[]> lines = new ArrayList<>();
    
        Scanner inputStream = new Scanner(file);
    
        float[][] result = new float[3][3];
        int c=0;
        while(inputStream.hasNextLine())
        {
    
                String line = inputStream.nextLine().trim();
                String[] firstSplit = line.split(":");
                String[] secondSplit = firstSplit[1].split(",");
    
                for(int i=0;i< secondSplit.length;i++)
                {
                    String temp=secondSplit[i];
                    float price= Float.parseFloat(temp);
                    result[c][i]=price;
                }
    
    
                for(int m=0;m<result[c].length;m++)
                    {
                        System.out.print(result[c][m] + "--");
                    }
                c++;
                System.out.println();
    
        } 
    }
    }
    
