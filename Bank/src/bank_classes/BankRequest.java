package bank_classes;
import interfaces.QueueAsList;
import java.util.*;

public class BankRequest {
  private static QueueAsList requests = new QueueAsList();
  
  
  public static QueueAsList addRequest(UserRequest request){
	requests.enqueue(request);
	return requests;
  }


  public static QueueAsList getBankRequests(){ return requests; }


//   public static UserRequest findLoanById(int id){
// 	  if (requests.size() == 0) return null;
// 	  for (int i=0; i< requests.size(); i++) {

// 		//   if(loans.get(i).getId().equals(id)) return loans.get(i);		
// 	  }
// 	  System.out.println("name was not found");
// 	  return null;
//   }
  
  
//   public static UserRequest deleteLoan(int id){
// 	  if (requests.size() == 0) return null;
	  
// 	  for (int i=0; i< requests.size(); i++) {
// 		  // if(this.loans.get(i).id.equals(id)) return this.loans.get(i);				// No method getName
// 	  }
// 	  System.out.println("name was not found");
// 	  return null;
//   }
  
}
