package menus;
import java.util.*;
import connection.RoleAns;
import role_classes.User;



public abstract class RegisterMenu {
    




    public static void ShowRegisterMenu(){
        User current = new User();
        // System.out.println("enter name");
        current.setName(RoleAns.stringInput("enter first name", 2, 10, ));
        current.setLastName(RoleAns.StringInput("enter first name", 2, 10));




    }
}
