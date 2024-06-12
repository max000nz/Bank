
import java.util.Scanner;
import menus.LoginMenu;

public class Main {
	public static void main(String args[]){ // need to ask if login or register 
        Scanner input = new Scanner(System.in);
        switch(LoginMenu.ShowLoginMenu(input))
        {
            case ADMIN:
            break;

            case USER:
            break;
            
        }
        input.close();
    }
}
