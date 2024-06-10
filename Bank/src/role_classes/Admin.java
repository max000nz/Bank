package role_classes;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import enums.RoleType;


public class Admin extends Roles {
	public static  LinkedList<User> users= UsersList.getUsers(); 
	public static LinkedList<UserRequest> bankReq = BankRequest.getBankRequests();
	public static Queue<BankRequest>allBankLoans=new LinkedList<BankRequest>();
	public static Queue<BankRequest>allBankDeposite=new LinkedList<BankRequest>();
	  
	
	//functions
	
	public static LinkedList<User> GetUsers() {
	return Admin.users;
	}

  
  public  Admin(String name, String lastName, int id, String password, RoleType role){
    super(name, lastName, id, password, role );
  }
  
  private BankRequest GetTransactionHistory() {
  	
  }
  
  public static void DeleteUser(int id)
  {
  	for(int i=0; i<Admin.users.size(); i++){
  		User temp = Admin.users.get(i);
  		if(temp.GetId()==id) {
        Admin.users.remove(i);
        System.out.println("User"+id+"hes been deleted");
      }
  		else System.out.println("User Not Found");
  	}
  }
  
  
  //private GetAnalytics(){
  //implementation of Binary tree  
  //}
  
  
  private boolean ApproveRequest()
  {
    return true;
  }
}
