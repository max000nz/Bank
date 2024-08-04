package bank_classes;
import data_structure.ThreeBranchTree;
import java.time.LocalTime;
import java.util.*;

public abstract class BankRequest {
	private static Queue<UserRequest> requests = new LinkedList<>();
	private static LinkedList<UserRequest> approvedRequests = new LinkedList<>();
	private static int loanNum = 0;	
	private static int depositNum = 0;
	private static float loanSum = 0;
	private static float depositSum = 0;
	private static float profit = 0;

	// Adds a new request to the queue.
	public static void addRequest(UserRequest request){
		requests.add(request);
	}

	// Approves a request, and adds it to the linked list.
	public static boolean approveRequestB(){
		if(requests == null) return false;
		if(requests.size()==0) return true;
		approvedRequests.add(requests.remove());
		return true;
	}

	// Checks if the request queue is empty.
	public static boolean isEmptyRequests(){
		if(requests.isEmpty() == true) return true;
		return false;
	}
	
	// Checks if the approved request linked list is empty.
	public static boolean isEmptyApprovedRequests(){
		if(approvedRequests.isEmpty() == true) return true;
		return false;
	
	}

	// Denies a request.
	public static boolean denyRequest(){
		if(requests==null) return false;
		requests.remove();
		return true;
	}

	// Deletes an approved request, and inserts into to the history tree.
	public static void deleteApprovedRequest(UserRequest request){
		ThreeBranchTree.insertNode(request);
		approvedRequests.remove(request);
	}

	// Deletes a "Close" type request from the queue.
	public static void deleteCloseRequest(UserRequest request){
		requests.remove(request);
	}

	// Returns a specific request for its unique id from the queue.
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

	// Returns a specific request for its unique id from the linked list.
	public static UserRequest findAprrovedRequestById(UUID id){
		if (approvedRequests.size() == 0) return null;
		for (UserRequest curr : approvedRequests) {
			if(curr.getId() == id){
				return curr;
			}
		}
		return null;
	}

	// Calculates and returns the amount of money that the user owes or is owed base on the time passed since the requests approval.
	public static float getNewAmount(UUID elem){
		LocalTime time = LocalTime.now();
		UserRequest curr_request = BankRequest.findAprrovedRequestById(elem);
		float newAmount = curr_request.getAmount();
		if (curr_request.isPendingToClose() == true)
			return -1; // Continue in the outer loop
		int timePassed = (time.toSecondOfDay()/60) - curr_request.getStartTime();
			for(int t=0; t<timePassed; t++){
			newAmount = newAmount*(1+(float)curr_request.getInterest()/100);
		}
		return newAmount;
	}

	// Getters
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
	public static int getLoanNum() {
		return loanNum;
	}

	public static int getDepositNum() {
		return depositNum;
	}

	public static float getLoanSum() {
		return loanSum;
	}

	public static float getDepositSum() {
		return depositSum;
	}

	public static float getProfit() {
		return profit;
	}

	// Loan/Deposit counter controlling functions.
	public static void increaseLoanNum() {
		BankRequest.loanNum++;
	}

	public static void decreaseLoanNum() {
		BankRequest.loanNum--;
	}

    public static void increaseDepositNum() {
        BankRequest.depositNum++;
    }

	public static void decreaseDepositNum() {
        BankRequest.depositNum--;
    }

    public static void increaseLoanSum(float cash) {
        BankRequest.loanSum += cash;
    }

	public static void decreaseLoanSum(float cash) {
        BankRequest.loanSum -= cash;
    }

	public static void increaseDepositSum(float cash) {
		BankRequest.depositSum += cash;
	}

	public static void decreaseDepositSum(float cash) {
		BankRequest.depositSum -= cash;
	}

	public static void increaseProfit(float cash) {
		BankRequest.profit += cash;
	}

	public static void decreaseProfit(float cash) {
		BankRequest.profit -= cash;
	}
}
