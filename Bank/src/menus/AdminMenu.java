package menus;

import java.util.Scanner;

public class AdminMenu {
 public static void showAdminMenu()
 {
    boolean working=true;
    int choice=0;
    while (working) {
        System.out.println("Hello Admin!");//we want the admin name to show?
        System.out.println("1.Option 1");//fill option later
        System.out.println("2.Option 2");
        System.out.println("3.Option 3");
        System.out.println("4.Option 4");
        System.out.println("5.Option 5");
        System.out.println("0.exit");
        System.out.println("Enter Choice: ");
        Scanner myObj=new Scanner(System.in);
        int userchoice=myObj.nextInt();
        switch (userchoice) {
            case 1 -> {
            }

            case 2 -> {
            }

            case 3 -> {
            }

            case 4 -> {
            }

            case 5 -> {
            }

            case 0 -> working=false;
            default -> throw new AssertionError();
        }


    }
 }
}
