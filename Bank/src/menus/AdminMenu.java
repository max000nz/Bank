package menus;
import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import connection.RoleAns;
import data_structure.ThreeBranchTree;
import enums.RequestType;
import java.util.LinkedList;
import java.util.Scanner;
import role_classes.*;

public abstract  class AdminMenu {

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
                int transaction_choice = RoleAns.choiceInput("1.Show Loan History\n2.Show Deposit History", 1, 2, input);
                switch (transaction_choice) {
                  case 1:
                    ThreeBranchTree.printTransactionHistory(ThreeBranchTree.getLoanRoot());
                    break;
                  case 2:
                    ThreeBranchTree.printTransactionHistory(ThreeBranchTree.getDepositRoot());
                    break;
                  default:
                      System.out.println("Error when printing transactions");
                }
              
                break;
            
            
            case 3:
                while (true){
                    int user_id= RoleAns.idInput("\"Please provide an id: ", 0, 999999999, input);
                    if(user_id == 0) break; 
                    else if(user_id < 100000000 || user_id > 999999999){
                        System.out.println("Please enter a 9 digit number");
                        int choice = -1;
                        choice = RoleAns.choiceInput("Would you like to continue?\n0.No\n1.Yes", 0, 1, input);
                        if(choice == 0) break;
                        continue;
                    }
                    admin.DeleteUser(user_id);
                    break;
                }

            break;
            
            case 4:
              System.out.println("\nLoans: " + BankRequest.getLoanNum());
              System.out.println("Cash Loaned: " + BankRequest.getLoanSum());
              System.out.println("Deposits: " + BankRequest.getDepositNum());
              System.out.println("Cash Deposited: " + BankRequest.getDepositSum());
              System.out.println("Profit: " + BankRequest.getProfit());
            break;
            case 5:
                while(approveLoop){
                    if(BankRequest.isEmptyRequests() == true){
                        System.out.println("No more requests, going back to menu");
                        break;
                    }
                    UserRequest curr_req = BankRequest.getFirstRequest();
                    User curr_user = UsersList.findUsertById(curr_req.getUserId());
                    System.out.println("User Id: " + curr_req.getUserId());
                    System.out.println("User Name: " + curr_user.getName());
                    System.out.println("User Last name: " + curr_user.getLastName());
                    System.out.println("Message: " + curr_req.getMessage());
                    System.out.println("Amount: " + curr_req.getAmount());
                    System.out.println("Type: " + curr_req.getType());
                    int choice=-1;
                    choice = RoleAns.choiceInput("Do you want to approve?\n1.Yes\n2.No\n3.Exit", 1, 3, input);
                    switch(choice){
                        case 1:
                            try {
                                if(admin.handleApprovedRequest(input)){
                                    
                                    if(curr_req.getType() != RequestType.CLOSE_DEPOSIT &&  curr_req.getType() != RequestType.CLOSE_LOAN){
                                        BankRequest.approveRequestB();
                                    }
                                    
                                    if(BankRequest.getRequestsSize() == 0){
                                        System.out.println("No more requests");
                                        break;
                                    }
                                }else{
                                    System.out.println("Cannot approve");
                                    admin.denyRequest();
                                }
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                            
                        break;
                        case 2:
                            admin.denyRequest();
                            if(curr_req.getType() == RequestType.CLOSE_DEPOSIT ||  curr_req.getType() == RequestType.CLOSE_LOAN){
                                curr_req.setPendingToClose(false);
                            }
                        break;
                        case 3:
                            approveLoop = false;
                        break;
                    }
                }
                
                break;
        }
    }
 }

}
