package menus;
import java.util.*;
import connection.RoleAns;
import enums.RoleType;
import role_classes.User;



public abstract class RegisterMenu {
    




    public static void ShowRegisterMenu(){
        User current = new User();
        current.setRole(RoleType.USER);
        current.setName(RoleAns.stringInput("enter first name", 2, 10, true));
        current.setLastName(RoleAns.stringInput("enter first name", 2, 10, true));
        current.setId(RoleAns.intInput("enter id", 100000000, 999999999));
        current.setPassword(RoleAns.stringInput("enter first name", 2, 10, false));
        /*
         * confirm password
         * valitaion for if there is user with same id
         * add to users list
         * go to user manu
         */

         UserMenu.ShowUserMenu




    }
}
