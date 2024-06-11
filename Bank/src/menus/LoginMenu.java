package menus;

import bank_classes.UsersList;
import connection.RoleAns;
import enums.RoleType;
import java.util.LinkedList;
import java.util.Scanner;
import role_classes.Roles;

public abstract class LoginMenu {

    public static RoleType ShowLoginMenu(Scanner input){
        System.out.println("Welcome!\n");
        
        while(true){

            int id=0;
            try {
                id = RoleAns.idInput("Please enter your id: ", 100000000, 999999999,input);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            String password="";
            try {
                password = RoleAns.passwordInput("Please enter your password: ", 100000000, 999999999,input);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            LinkedList<Roles> users = UsersList.getUsers();

            for (Roles elem : users) {
                if(elem.SearchInfo(id,password));
                System.out.println("Logging in...");
                return elem.getRole(); 
            }

            System.out.println("Incorrect. Try again.\n");
        }
    }

}
