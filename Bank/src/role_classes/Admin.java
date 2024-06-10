package role_classes;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.UUID;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import enums.RoleType;


public class Admin extends Roles {

	public static Queue<UserRequest> bankReq = BankRequest.getBankRequests();
	public static Queue<BankRequest>allBankLoans=new LinkedList<BankRequest>();
	public static Queue<BankRequest>allBankDeposite=new LinkedList<BankRequest>();


  public  Admin(String name, String lastName, int id, String password, RoleType role){
    super(name, lastName, id, password, role );
  }

  private BankRequest GetTransactionHistory() {
    // returns the tree;
  }
  

  public static void DeleteUser(int user_id)
  {
  	UsersList.removeUser(user_id, id);
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
    int id = BankRequest.getFirstRequest().getUserId();
    float userCash = UsersList.findUsertById(id).GetCash();
    if(BankRequest.getFirstRequest().getAmount() >= userCash){
      
    }
    return true;
  }
}