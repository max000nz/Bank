package connection;
import java.util.*;


public class RoleAns {
    



    public static String stringInput(String message, int minLenght, int maxLenght , boolean space ){
      String current = null;
      Scanner input = new Scanner(System.in);
      while(true){
        System.out.println(message + "with lenght between: " + minLenght + " and " + maxLenght);
        current = input.nextLine();
        if (validateString(minLenght, maxLenght, space)) { break; }
      }
      return current;
    }

    public static int intInput(String message, int minLenght, int maxLenght){
       String current;
       int currInt = 0;
       Scanner input = new Scanner(System.in);
       while(true){
        System.out.println(message + "between " + minLenght + " and " + maxLenght);
        current = input.nextLine();
        if (validateInt(minLenght, maxLenght)) { 
            currInt = Integer.parseInt(current);
            break; }
      }
        return 0;
    }

    public static float floatInput(String message, int minLenght, int maxLenght){
        float current;
        Scanner input = new Scanner(System.in);
        while(true){
         System.out.println(message + "between " + minLenght + " and " + maxLenght);
         current = input.nextFloat();
         if (validateFloat(minLenght, maxLenght)) { break; }
       }
         return 0;
     }


    protected static boolean validateString(int min, int max, boolean space){
        // need to create valitation for string (lenght, relevant letters and space)
        return true;
    }

    protected static boolean validateInt(int min, int max){
        // need to create valitation for int (lenght, relevant letters and space)
        return true;
    }

    protected static boolean validateFloat(int min, int max){
        // need to create valitation for string (lenght, relevant letters and space)
        return true;
    }
}
