
import bank_classes.UsersList;
import connection.RoleAns;
import java.util.Scanner;
import menus.AdminMenu;
import menus.LoginMenu;
import menus.RegisterMenu;
import menus.UserMenu;
import role_classes.Admin;
import role_classes.Roles;
import role_classes.User;

public class Main {
	public static void main(String args[]) throws Exception{ 
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin("max", "pro" , 222222222, "ben", enums.RoleType.ADMIN);
        User user = new User("liad", "mandil", 111111111, "liad" , enums.RoleType.USER);
        UsersList.addUser(user);
        int choice = 0;
        UsersList.addUser(admin);
        while(true){
            choice = RoleAns.choiceInput("1.register\n2.login\n0.close program", 0, 2, input);
            Roles curr = null;
            switch (choice) {
                case 0:
                    System.out.println("See you next time!");
                    break;
                case 1:
                curr = RegisterMenu.ShowRegisterMenu(input);
                if(curr == null) break;
                UserMenu.ShowUserMenu(((role_classes.User) curr), input);
                    break;
                case 2:
                curr = LoginMenu.ShowLoginMenu(input);
                    switch(curr.getRole())
                    {
                        case ADMIN:
                            AdminMenu.showAdminMenu(((role_classes.Admin) curr), input);
                        break;
            
                        case USER:
                            UserMenu.ShowUserMenu(((role_classes.User) curr), input);
                        break;
                        
                    }
                    break;
                default:
                    break;
            }
    
            
        if(choice == 0) break; 
        }
        
    }
}
