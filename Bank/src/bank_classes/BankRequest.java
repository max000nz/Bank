package bank_classes;
import java.util.*;

public abstract class BankRequest {
  private static Queue<UserRequest> requests = new LinkedList<UserRequest>();
  private static Queue<UserRequest> approvedRequests = new LinkedList<UserRequest>();

  public static void addRequest(UserRequest request){
	requests.add(request);
  }

  public static boolean approveRequest(){
	if(requests==null) return false;
	approvedRequests.add(requests.peek());
	requests.remove();
	return true;
  }

  public static boolean denyRequest(){
	if(requests==null) return false;
	requests.remove();
	return true;
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

  public static int getRequestsSize(){
	return requests.size();
  }

  public static int getapprovedRequestsSize(){
	return approvedRequests.size();
  }

  public static UserRequest getFirstRequest(){
	return requests.peek();
  }
  
  
}
