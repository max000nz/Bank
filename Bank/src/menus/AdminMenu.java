package menus;

import bank_classes.UsersList;
import java.util.LinkedList;
import java.util.Scanner;
import role_classes.*;

public class AdminMenu {
 public static void showAdminMenu(Admin admin)
 {

    boolean working=true;
    LinkedList<Roles> users=UsersList.getUsers();
    while (working) {
        System.out.println("Hello Admin!");//we want the admin name to show?
        System.out.println("1.Show all Users");//fill option later
        System.out.println("2.Show Transaction History");
        System.out.println("3.Delete User");
        System.out.println("4.Get analytics");
        System.out.println("5.Approve Requests");
        System.out.println("0.exit");
        System.out.println("Enter Choice: ");
        Scanner myObj=new Scanner(System.in);
        int userchoice=myObj.nextInt();
        switch (userchoice) {

            case 1 -> {
              for (Roles elem : users) {
                  System.out.println(elem.GetId());
                  System.out.println(elem.getName());
                  if(elem instanceof User) System.out.println(((User) elem).GetCash());
                  System.out.println();
              }
            }

            case 2 -> {
            }

            case 3 -> {
                System.out.println("Please provide an id: ");
                int user_id=myObj.nextInt();
                admin.DeleteUser(user_id);
            }
            
            case 4 -> {
                break;
            }
            

            case 5 -> {
                break;
            }

            case 0 -> { 
                working=false; 
                break;
            }

            default -> throw new AssertionError();
        }


    }
 }

}
