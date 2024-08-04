
import bank_classes.UsersList;
import connection.RoleAns;
import java.util.Scanner;
import menus.AdminMenu;
import menus.LoginMenu;
import menus.RegisterMenu;
import menus.UserMenu;
import role_classes.Admin;
import role_classes.Roles;

public class Main {
    
	public static void main(String args[]) throws Exception{ 
        Scanner input = new Scanner(System.in);
        Admin admin = new Admin("Admin", "" , 222222222, "admin", enums.RoleType.ADMIN);
        UsersList.addUser(admin);
        int choice = 0;
        while(true){
            choice = RoleAns.choiceInput("\n1.Register\n2.Login\n0.Close program", 0, 2, input);
           Roles curr = null;
            switch (choice) {
                case 0:
                    System.out.println("\nSee you next time!");
                    break;
                case 1:
                curr = RegisterMenu.ShowRegisterMenu(input);
                if(curr == null) break;
                UserMenu.ShowUserMenu(((role_classes.User) curr), input);
                    break;
                case 2:
                curr = LoginMenu.ShowLoginMenu(input);
                    if(curr == null) continue;
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
