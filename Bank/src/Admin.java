import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Admin extends Roles {
	public LinkedList<User> users=new LinkedList<User>(); 
	public Stack<UserRequest> bankReq=new Stack<UserRequest>();
	public Queue<BankLoans> allBankLoans=new LinkedList<BankLoans>();
	public Queue<BankDeposit>allBankDeposite=new LinkedList<BankDeposit>();
	

	private Admin(){
		super();
	}
	
	//functions
	
	private User GetUsers() {
	return this.users.getFirst();
	}


	private BankDeposit GetTransactionHistory() {
	
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


	private boolean ApproveRequest(){

	}

}