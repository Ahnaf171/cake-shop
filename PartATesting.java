import java.io.IOException;
import java.io.File;

public class PartATesting {
    public static void main(String[] args) throws IOException {

        float expectedP;
        float actualP;
        boolean pass;
        CakeInfo cakeInfo = new CakeInfo();
        Cake cake;
	    Cake cakeB;
        Cake cakeC;
        Cake cakeD;

        System.out.println(new File(".").getAbsolutePath());
        cake = new Cake("hojicha", 3, "gluten-free");
        System.out.println("Test 1 - 3-layer hojicha gluten-free for $160.00");
        // the expected output value
        expectedP = 160.00f; 
        // calling the calCakeInfo method
        actualP = cakeInfo.calCakePrice(cake); 
        pass = actualP == expectedP;
        if (pass){  
            System.out.println("Passed this test for calCakePrice in CakeInfo class");
        }else{
            System.out.println("Failed this test for calCakePrice in CakeInfo class, the expected value is " + Float.toString(expectedP) + " but the actual value is "+Float.toString(actualP)+". Please check your code!");
        }

        cakeB = new Cake("espresso", 1, "none");
        System.out.println("Test 2 - 1-layer espresso no dietary requirements for $40.00");
        // the expected output value
        expectedP = 40.00f; 
        // calling the calCakeInfo method
        actualP = cakeInfo.calCakePrice(cakeB); 
        pass = actualP == expectedP;
        if (pass){
            System.out.println("Passed this test for calCakePrice in CakeInfo class");
        }else{
            System.out.println("Failed this test for calCakePrice in CakeInfo class, the expected value is " + Float.toString(expectedP) + " but the actual value is "+Float.toString(actualP)+". Please check your code!");
        }




        cakeC = new Cake("opera",  1, "gluten-free");
        System.out.println("Test 3 - 1-layer opera gluten-free for $100.00");
        // the expected output value
        expectedP = 100.00f; 
        // calling the calCakeInfo method
        actualP = cakeInfo.calCakePrice(cakeC); 
        pass = actualP == expectedP;
        if (pass){  
            System.out.println("Passed this test for calCakePrice in CakeInfo class");
        }
        else{
            System.out.println("Failed this test for calCakePrice in CakeInfo class, the expected value is " + Float.toString(expectedP) + " but the actual value is "+Float.toString(actualP)+". Please check your code!");
        }



        // testing for a flavour not in list
        cakeD = new Cake("notInList", 1, "gluten-free");
        System.out.println("Test 4 - 3-layer notInList gluten-free for $160.00");
        // the expected output value
        expectedP = 50.00f; 
        // calling the calCakeInfo method
        actualP = cakeInfo.calCakePrice(cakeD); 
        pass = actualP == expectedP;
        if (pass){  
            System.out.println("Passed this test for calCakePrice in CakeInfo class");
        }else{
            System.out.println("Failed this test for calCakePrice in CakeInfo class, the expected value is " + Float.toString(expectedP) + " but the actual value is "+Float.toString(actualP)+". Please check your code!");
        }
    }
}