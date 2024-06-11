package menus;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import connection.RoleAns;
import java.util.LinkedList;
import java.util.Scanner;
import role_classes.*;

public class AdminMenu {

 public static void showAdminMenu(Admin admin, Scanner input)
 {
    boolean working=true;
    boolean approveLoop=true;
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

            case 1:
              for (Roles elem : users) {
                  System.out.println(elem.getId());
                  System.out.println(elem.getName());
                  if(elem instanceof User) System.out.println(((User) elem).GetCash());
                  System.out.println();
              }
            break;

            case 2:
            
            break;
            case 3:
                System.out.println("Please provide an id: ");
                int user_id=myObj.nextInt();
                admin.DeleteUser(user_id);
            break;
            
            case 4:
            break;
            case 5:
                while(approveLoop){
                    UserRequest curr_req = BankRequest.getFirstRequest();
                    User curr_user = UsersList.findUsertById(curr_req.getUserId());
                    System.out.println("User Id: " + curr_req.getUserId());
                    System.out.println("User Name: " + curr_user.getName());
                    System.out.println("User Last name: " + curr_user.getLastName());
                    System.out.println("Message: " + curr_req.getMessage());
                    System.out.println("Amount: " + curr_req.getAmount());
                    System.out.println("Type: " + curr_req.getType());
                    int choice=0;
            try {
                choice = RoleAns.choiceInput("Does you want to approve?\n1.Yes\n2.No\n3.Exit", 1, 3, input);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
                    switch(choice){
                        case 1:
                            if(admin.handleApprovedRequest()){
                                admin.approveRequest();
                            }else{
                                System.out.println("Cannot approve");
                                admin.denyRequest();
                            }
                        break;
                        case 2:
                            admin.denyRequest();
                        break;
                        case 3:
                            approveLoop = false;
                        break;
                    }
                }
                break;

            //default -> throw new AssertionError();
        }


    }
 }

}
