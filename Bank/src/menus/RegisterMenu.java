package menus;
import bank_classes.UsersList;
import connection.RoleAns;
import enums.RoleType;
import role_classes.User;



public abstract class RegisterMenu {
    




    public static void ShowRegisterMenu(){
        User current = new User();
        current.setRole(RoleType.USER);
        current.setName(RoleAns.stringInput("Please Enter first name", 2, 10, true));
        current.setLastName(RoleAns.stringInput("PLease Enter last name", 2, 10, true));
        current.setId(RoleAns.intInput("please Enter id", 100000000, 999999999));
        if(UsersList.checkIfexist(current.getId())){ 
            System.out.println("User already Exist in the system!");
            return;
        }  //Valdtion check if user exist... 
        current.setPassword(RoleAns.stringInput("Please Enter password: ", 2, 10, false));
        /*
         * confirm password
        
         
         * go to user manu
        */
        UsersList.addUser(current); //add user to userlist


         UserMenu.ShowUserMenu(current);




    }
}
