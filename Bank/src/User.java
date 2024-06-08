import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class User {
	
	//Stack<Request> pendingRequests;			Implement after adding the 'Request' class
	//Queue<Request> loans;						Implement after adding the 'Request' class
	//Queue<Request> deposits;					Implement after adding the 'Request' class
	
	private float cash;
	private float totalLoans;
	private float totalDeposits;
	
	public User() {
		
		//pendingRequests = new Stack<>();		Implement after adding the 'Request' class
		//loans = new ArrayDeque<>();				Implement after adding the 'Request' class
		//deposit = new ArrayDeque<>();			Implement after adding the 'Request' class
		
        this.cash = 0;
        this.totalLoans = 0;
        this.totalDeposits = 0;
    }
	
	public void NewLoanR() {
		// The function creates a Loan object and adds it to the the queue.
		
		//Loan new_loan = new Loan();
		//loans.add(new_loan);
	}
	
	public void NewDepositR() {
		// The function creates a Deposit object and adds it to the the queue.
		
		//Deposit new_deposit = new Deposit();
		//deposits.add(new_deposit);
	}
	
	public void PayoutLoanR() {
		// The function deletes a Loan object from the end of the queue and subtracts the sum that needs to be paid from 'cash'.
		
		//Loan payout = loans.remove();
		//this.cash -= payout.getValue();
	}
	
	public void WithdrawDepositR() {
		// The function deletes a Loan object from the end of the queue and adds the sum that needs to be paid to 'cash'.
		
		//Deposit withdrawal = deposits.remove();
		//this.cash += withdrawal.getValue();
	}
	
	public float GetTotalLoans() {
		return totalLoans;
	}
	
	public float GetTotalDeposit() {
		return totalDeposits;
	}

}