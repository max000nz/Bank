package menus;
import bank_classes.UsersList;
import connection.RoleAns;
import enums.RoleType;
import java.util.Scanner;
import role_classes.*;



public abstract class RegisterMenu {
    
    public static User ShowRegisterMenu(Scanner input){
        User current = new User();
        current.setRole(RoleType.USER);
        current.setName(RoleAns.namesInput("\nPlease enter your first name:", 2, 10, input));
        current.setLastName(RoleAns.namesInput("\nPlease enter your last name:", 2, 10, input));
        current.setId(RoleAns.idInput("\nPlease enter your id:", 100000000, 999999999, input));
        
        if(UsersList.checkIfexist(current.getId())){ 
            System.out.println("\nUser already exist in the system!");
            return null;
        }  //Valdtion check if user exist... 

        current.setPassword(RoleAns.passwordInput("\nPlease enter your password: ", 2, 10, input));

        /*
         * confirm password
        
         * go to user manu
        */
        UsersList.addUser(current); //add user to userlist
        return current;

    }
}
