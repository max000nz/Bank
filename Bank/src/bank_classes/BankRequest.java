package bank_classes;
import java.util.*;

public class BankRequest {
  private static Queue<UserRequest> requests = new LinkedList<UserRequest>();

  public static Queue<UserRequest> addRequest(UserRequest request){
	requests.add(request);
	return requests;
  }

  public static Queue<UserRequest> getBankRequests(){ return requests; }

  public static UserRequest findRequestById(UUID id){
	  if (requests.size() == 0) return null;
	  for (UserRequest curr : requests) {
		   if(curr.getId() == id){
				return curr;
		   }
	  }
	  return null;
  }

  
//   public static UserRequest deleteLoan(int id){
// 	  if (requests.size() == 0) return null;
	  
// 	  for (int i=0; i< requests.size(); i++) {
// 		  // if(this.loans.get(i).id.equals(id)) return this.loans.get(i);				// No method getName
// 	  }
// 	  System.out.println("name was not found");
// 	  return null;
//   }
  
}
