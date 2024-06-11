package menus;
import bank_classes.UsersList;
import connection.RoleAns;
import enums.RoleType;
import java.util.Scanner;
import role_classes.User;



public abstract class RegisterMenu {
    
    public static void ShowRegisterMenu(Scanner input){
        User current = new User();
        current.setRole(RoleType.USER);
        try {
            current.setName(RoleAns.namesInput("Please Enter first name", 2, 10, input));
            current.setLastName(RoleAns.namesInput("PLease Enter last name", 2, 10, input));
            current.setId(RoleAns.idInput("please Enter id", 100000000, 999999999, input));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        if(UsersList.checkIfexist(current.getId())){ 
            System.out.println("User already Exist in the system!");
            return;
        }  //Valdtion check if user exist... 
        try {
            current.setPassword(RoleAns.passwordInput("Please Enter password: ", 2, 10, input));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        /*
         * confirm password
        
         * go to user manu
        */
        UsersList.addUser(current); //add user to userlist

        UserMenu.ShowUserMenu(current, input);

    }
}
