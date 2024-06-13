package bank_classes;
import data_structure.ThreeBranchTree;
import java.util.*;

public abstract class BankRequest {
  private static Queue<UserRequest> requests = new LinkedList<>();
  private static LinkedList<UserRequest> approvedRequests = new LinkedList<>();
  
  public static void addRequest(UserRequest request){
	requests.add(request);
  }

  public static boolean approveRequestB(){
	if(requests == null) return false;
	if(requests.size()==0) return true;
	approvedRequests.add(requests.remove());
	return true;
  }

  public static boolean isEmptyRequests(){
	if(requests.isEmpty() == true) return true;
	return false;
  }
  
  public static boolean isEmptyApprovedRequests(){
	if(approvedRequests.isEmpty() == true) return true;
	return false;
  }

  public static boolean denyRequest(){
	if(requests==null) return false;
	requests.remove();
	return true;
  }

  public static void deleteApprovedRequest(UserRequest request){
	for (UserRequest curr : approvedRequests) {
		if(curr.getId() == request.getId()){
			ThreeBranchTree.insertNode(curr);
			approvedRequests.remove(curr);
			return;
		}
   	}
  }

  public static void deleteCloseRequest(UUID requestId){
	for (UserRequest curr : requests) {
		if(curr.getId() == requestId){
			requests.remove(curr);
			return;
		}
   	}
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

  public static UserRequest findAprrovedRequestById(UUID id){
	  if (approvedRequests.size() == 0) return null;
	  for (UserRequest curr : approvedRequests) {
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
	if(BankRequest.getRequestsSize() == 0){
		return null;
	} 
	return requests.peek(); 
  }
}
