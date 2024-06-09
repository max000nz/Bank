package bank_classes;
import java.util.LinkedList;

public class BankLoans {
  private static LinkedList<UserRequest> loans = new LinkedList<UserRequest>();
  
  

  public UserRequest findLoanById(int id){
	  if (loans.size() == 0) return null;
	  for (int i=0; i< loans.size(); i++) {
		   if(loans.get(i).getId() == id) return loans.get(i);		
	  }
	  System.out.println("name was not found");
	  return null;
  }
  
  
  public UserRequest deleteLoan(int id){
	  if (loans.size() == 0) return null;
	  
	  for (int i=0; i< loans.size(); i++) {
		  // if(this.loans.get(i).id.equals(id)) return this.loans.get(i);				// No method getName
	  }
	  System.out.println("name was not found");
	  return null;
  }
  
}
