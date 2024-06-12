package menus;

import bank_classes.UsersList;
import connection.RoleAns;
import java.util.LinkedList;
import java.util.Scanner;
import role_classes.Roles;

public abstract class LoginMenu {

    public static Roles ShowLoginMenu(Scanner input){
        System.out.println("Welcome!\n");
        
        while(true){

            int id=0;
            id = RoleAns.idInput("Please enter your id: ", 100000000, 999999999, input);
            String password="";
            password = RoleAns.passwordInput("Please enter your password: ", 100000000, 999999999, input);
            LinkedList<Roles> users = UsersList.getUsers();

            for (Roles elem : users) {
                if(elem.SearchInfo(id,password));
                System.out.println("Logging in...");
                return (elem); 
            }

            System.out.println("Incorrect. Try again.\n");
            return null;
        }
    }

}
