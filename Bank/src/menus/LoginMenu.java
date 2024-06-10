package menus;

import bank_classes.UsersList;
import connection.RoleAns;
import java.util.LinkedList;
import role_classes.User;

public abstract class LoginMenu {

    public static void ShowLoginMenu(){

        System.out.println("Welcome!\n");
        
        while(true){

            int id = RoleAns.intInput("Please enter your id: ", 100000000, 999999999);
            String password = RoleAns.stringInput("Please enter your password: ", 100000000, 999999999, true);

            LinkedList<User> users = UsersList.getUsers();

            for(int i = 0; i < users.size(); i++){
                
                if(users.get(i).SearchInfo(id, password)){

                    System.out.println("\nLogging in...\n");
                    break;
                }
                
            }

            System.out.println("Incorrect. Try again.\n");
        }
    }

}
