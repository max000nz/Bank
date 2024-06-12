package menus;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import connection.RoleAns;
import java.util.LinkedList;
import java.util.Scanner;
import role_classes.*;

public class AdminMenu {

 public static void showAdminMenu(Admin admin, Scanner input) throws Exception
 {
    boolean working=true;
    boolean approveLoop=true;
    LinkedList<Roles> users=UsersList.getUsers();

    while (working) {
       
        int userchoice=RoleAns.choiceInput("\n" + "Hello"+ " " + admin.getName()+ " " + admin.getLastName() +"\n1.Show all Users\n2.Show Transaction History\n3.Delete User\n4.Get analytics\n5.Approve Requests\n0.exit\nEnter Choice:", 0, 5, input);
        switch (userchoice) {
            case 0:
            return;
            case 1:
            if(users.size()-1==0) {System.out.println("\n" + "Users list is empty"+ "\n"); break;}
              for (Roles elem : users) {
                  if(elem.getRole()==enums.RoleType.ADMIN) continue;
                  else{
                  System.out.println(elem.getId());
                  System.out.println(elem.getName());
                  if(elem instanceof User) System.out.println(((User) elem).GetCash());
                  System.out.println();
                  }
              }
            break;

            case 2:
            
            break;
            case 3:
                int user_id= RoleAns.idInput("\"Please provide an id: ", 100000000, 999999999, input);
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
                    choice = RoleAns.choiceInput("Do you want to approve?\n1.Yes\n2.No\n3.Exit", 1, 3, input);
                    switch(choice){
                        case 1:
                            if(admin.handleApprovedRequest(input)){
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
