package menus;

import java.util.LinkedList;
import java.util.Scanner;
import role_classes.Admin;
import role_classes.User;

public class AdminMenu {
 public static void showAdminMenu()
 {
    boolean working=true;
    LinkedList<User> users=Admin.GetUsers();
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
            case 1:
                for (User elem : users) {
                    System.out.println(elem.GetId());
                    System.out.println(elem.getName());
                    System.out.println(elem.GetCash());
                    System.out.println();
                }
                break;
           

            case 2:
            break;

            case 3:
                System.out.println("Please provide an id: ");
                int id=myObj.nextInt();
                Admin.DeleteUser(id);
            break;

            case 4:
            break;

            case 5:
            break;

            case 0 : 
            working=false; 
            break;
            default : throw new AssertionError();
        }


    }
 }

}
