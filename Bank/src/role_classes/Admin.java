package role_classes;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import enums.RoleType;


public class Admin extends Roles {
	public LinkedList<User> users= UsersList.getUsers(); 
	public LinkedList<UserRequest> bankReq = BankRequest.getBankRequests();
	public Queue<BankRequest> allBankLoans=new LinkedList<BankRequest>();
	public Queue<BankRequest>allBankDeposite=new LinkedList<BankRequest>();
	  
	
	//functions
	
	private User GetUsers() {
	return this.users.getFirst();
	}

  
  public  Admin(String name, String lastName, int id, String password, RoleType role){
    super(name, lastName, id, password, role );
  }
  
  private BankRequest GetTransactionHistory() {
  	
  }
  
  private void DeleteUser(int id)
  {
  	for(int i=0; i<this.users.size(); i++){
  		User temp = this.users.get(i);
  		if(temp.GetId()==id) this.users.remove(i);
  		else System.out.println("User Not Found");
  	}
  }
  
  
  //private GetAnalytics(){
  //implementation of Binary tree  
  //}
  
  
  private boolean ApproveRequest()
  {
  
  }
}
