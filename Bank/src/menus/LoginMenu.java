package menus;
import java.util.Scanner;

public abstract class LoginMenu {

    public static void ShowLoginMenu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!\n");

        System.out.print("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.print("\nPlease enter your password: ");
        String password = scanner.nextLine();

        scanner.close();
    }
}
