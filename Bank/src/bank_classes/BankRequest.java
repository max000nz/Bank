package bank_classes;
import java.util.*;

public class BankRequest {
  private static Queue<UserRequest> loans = new ArrayDeque<UserRequest>();
  
  

  public static Queue<UserRequest> getBankRequests(){ return loans; }


  public static UserRequest findLoanById(int id){
	  if (loans.size() == 0) return null;
	  for (int i=0; i< loans.size(); i++) {

		//   if(loans.get(i).getId().equals(id)) return loans.get(i);		
	  }
	  System.out.println("name was not found");
	  return null;
  }
  
  
  public static UserRequest deleteLoan(int id){
	  if (loans.size() == 0) return null;
	  
	  for (int i=0; i< loans.size(); i++) {
		  // if(this.loans.get(i).id.equals(id)) return this.loans.get(i);				// No method getName
	  }
	  System.out.println("name was not found");
	  return null;
  }
  
}
