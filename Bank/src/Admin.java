import java.util.*;

public class Admin extends Roles {
public LinkedList<User> users=new LinkedList<User>(); 
public Stack<UserRequest> bankReq=new Stack<UserRequest>();
public Queue<BankLoans> allBankLoans=new LinkedList<BankLoans>();
public Queue<BankDeposit>allBankDeposite=new LinkedList<BankDeposit>();
  

//functions

private User GetUsers() {
return this.users.getFirst();
}


private BankDeposit GetTransactionHistory() {

}

private void DeleteUser(int id)
{
for(int i=0; i<this.users.size(); i++){
this.users.get(i);
if(Roles.id==id) this.users.remove(i);
else
{
System.out.println("User Not Found");
}

}
}


//private GetAnalytics(){
//implementation of Binary tree  
//}


private boolean ApproveRequest()
{

}
}