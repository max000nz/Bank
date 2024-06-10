package menus;

import java.util.Scanner;

public abstract class LoginMenu {

    public static void ShowLoginMenu(){

        System.out.println("Welcome!\n");
        
        while(true){
            
            Scanner scanner = new Scanner(System.in);

            System.out.print("Please enter your id: ");
            String id = scanner.nextLine();
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();

            /*
            if(password is correct){

                System.out.println("\nLogging in...\n");
                scanner.close();
                break;

            }
            */

            System.out.println("Incorrect. Try again.\n");
        }
    }

}
