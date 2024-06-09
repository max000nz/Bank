package role_classes;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import bank_classes.BankLoans;
import bank_classes.UserRequest;
import enums.RoleType;


public class Admin extends Roles {
	public LinkedList<User> users=new LinkedList<User>(); 
	public Stack<UserRequest> bankReq=new Stack<UserRequest>();
	public Queue<BankLoans> allBankLoans=new LinkedList<BankLoans>();
	public Queue<BankDeposit>allBankDeposite=new LinkedList<BankDeposit>();
	  
	
	//functions
	
	private User GetUsers() {
	return this.users.getFirst();
	}

  
  public  Admin(String name, String lastName, int id, String password, RoleType role){
    super(name, lastName, id, password, role );
  }
  
  private BankDeposite GetTransactionHistory() {
  	
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
