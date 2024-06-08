import java.util.*;

public class Admin extends Roles {
public LinkedList<User> users=new LinkedList<User>(); 
public Stack<Request> bankReq=new Stack<Request>();
public Queue<BankLoans> allBankLoans=new LinkedList<BankLoans>();
public Queue<BankDeposite>allBankDeposite=new Queue<BankDeposite>();
  

//functions

private User GetUsers() {
return this.users.getFirst();
}


private BankDeposite GetTransactionHistory() {

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
}import java.util.*;

public class Admin extends Roles {
public LinkedList<User> users=new LinkedList<User>(); 
public Stack<Request> bankReq=new Stack<Request>();
public Queue<BankLoans> allBankLoans=new LinkedList<BankLoans>();
public Queue<BankDeposite>allBankDeposite=new Queue<BankDeposite>();
  
//gay
//functions

private User GetUsers() {
return this.users.getFirst();
}


private BankDeposite GetTransactionHistory() {

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