package role_classes;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import enums.RoleType;


public class Admin extends Roles {

	public LinkedList<UserRequest> bankReq = BankRequest.getBankRequests();
	public Queue<BankRequest> allBankLoans=new LinkedList<BankRequest>();
	public Queue<BankRequest>allBankDeposite=new LinkedList<BankRequest>();
	  
	//functions
  
  public  Admin(String name, String lastName, int id, String password, RoleType role){
    super(name, lastName, id, password, role );
  }

  private BankRequest GetTransactionHistory() {
    // returns the tree;
  }
  
  public void DeleteUser(int user_id)
  {
    UsersList.removeUser(user_id, id);
  }
  
  //private GetAnalytics(){
  //implementation of Binary tree  
  //}
  
  private boolean ApproveRequest()
  {
    return true;
  }
}
