package menus;

import bank_classes.UsersList;
import java.util.LinkedList;
import java.util.Scanner;
import role_classes.User;

public abstract class LoginMenu {

    public static void ShowLoginMenu(){

        System.out.println("Welcome!\n");
        
        while(true){
            
            Scanner scanner = new Scanner(System.in);

            System.out.print("Please enter your id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Please enter your password: ");
            String password = scanner.nextLine();

            LinkedList<User> users = UsersList.getUsers();

            for(int i = 0; i < users.size(); i++){
                
                if(users.get(i).SearchInfo(id, password)){

                    System.out.println("\nLogging in...\n");
                    scanner.close();
                    break;
                }
                
            }

            System.out.println("Incorrect. Try again.\n");
        }
    }

}
