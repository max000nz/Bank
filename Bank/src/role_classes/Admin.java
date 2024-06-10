package role_classes;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.UUID;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import enums.RequestType;
import enums.RoleType;


public class Admin extends Roles {

	public static Queue<UserRequest> bankReq = BankRequest.getBankRequests();
	public static Queue<BankRequest>allBankLoans=new LinkedList<BankRequest>();
	public static Queue<BankRequest>allBankDeposite=new LinkedList<BankRequest>();


  public  Admin(String name, String lastName, int id, String password, RoleType role){
    super(name, lastName, id, password, role );
  }

  // public BankRequest getTransactionHistory() {
  //    returns the tree;
  // }
  

  public void DeleteUser(int user_id)
  {
  	UsersList.removeUser(user_id, this.id);
  }

  //private GetAnalytics(){
  //implementation of Binary tree  
  //}
  
  public void approveRequest(){
    if(BankRequest.approveRequest() == false){
      System.out.println("No requests available");
      return;
    }
    System.out.println("Request approved");
  }

  public void denyRequest(){
    if(BankRequest.denyRequest() == false){
      System.out.println("No requests available");
      return;
    }
    System.out.println("Request denied");
  }

  public boolean handleApprovedRequest(){
    if(BankRequest.getRequestsSize() == 0){
      return false;
    }
    UserRequest curr_req = BankRequest.getFirstRequest();
    int id = curr_req.getUserId();
  
    switch(curr_req.getType()){
      case RequestType.LOAN:
        
      break;
      case RequestType.DEPOSIT:
          User curr_user = UsersList.findUsertById(id);
          if(curr_req.getAmount() > curr_user.GetCash() + curr_user.GetFrame()){
             System.out.println("error deposite bigger then your cash in the bank");
             break;
          }

          curr_user.SetCash(curr_user.GetCash() - curr_req.getAmount());
      break;
      case RequestType.CLOSE_LOAN:
      
      break;
      case RequestType.CLOSE_DEPOSIT:
      
      break;
    }
    
    return true;
  }
}