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
            //id = RoleAns.idInput("Please enter your id: ", 100000000, 999999999, input);

            String password="";
            LinkedList<Roles> users = UsersList.getUsers();
            int menu_count = 1;
            for(Roles elem : users){
                System.out.println(menu_count + " " + elem.getName() + " " + elem.getLastName() + " " + elem.getId());
                menu_count++;
            }
            System.out.println("0. Back");

            int choice = -1;
            choice = RoleAns.choiceInput("\nChoose a user: ", 0, menu_count-1, input);

            if(choice == 0) return null;

            password = RoleAns.passwordInput("Please enter your password: ", 100000000, 999999999, input);

            if(users.get(choice-1).SearchInfo(users.get(choice-1).getId(), password)){
                System.out.println("Logging in...");
                return (users.get(choice-1)); 
            }

            // for (Roles elem : users) {
            //     if(elem.SearchInfo(id,password)){
            //         System.out.println("Logging in...");
            //         return (elem); 
            //     }   
            // }

            System.out.println("Incorrect. Try again.\n");
        }
    }

}
