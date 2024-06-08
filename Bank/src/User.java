import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class User {
	
	//Stack<Request> pendingRequests;			Implement after adding the 'Request' class
	//Queue<Loan> loans;					Implement after adding the 'Loan' class
	//Queue<Deposit> deposits;				Implement after adding the 'Deposit' class
	
	private float cash;
	private float totalLoans;
	private float totalDeposits;
	
	public User() {
		
		//pendingRequests = new Stack<>();		Implement after adding the 'Request' class
		//queue = new ArrayDeque<>();			Implement after adding the 'Loan' class
		//deposit = new ArrayDeque<>();			Implement after adding the 'Deposit' class
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
	}
	
	public void WithdrawDepositR() {
		// The function deletes a Loan object from the end of the queue and subtracts the sum that needs to be paid from 'cash'.
	}
	
	public void GetTotalLoans() {
		
	}
	
	public void GetTotalDeposite() {
		
	}

}
