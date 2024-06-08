import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class User extends Roles {
	
	Stack<UserRequest> requestHistory;
	Queue<UserRequest> loans;
	Queue<UserRequest> deposits;
	
	private float cash;
	private float totalLoans;
	private float totalDeposits;
	
	public User() {
		
		super()
		
		requestHistory = new Stack<>();
		loans = new ArrayDeque<>();
		deposits = new ArrayDeque<>();
		
        this.cash = 0;
        this.totalLoans = 0;
        this.totalDeposits = 0;
    }
	
	public void NewLoanR() {
		// The function creates a Loan object and adds it to the the queue.
		
		UserRequest new_loan = new UserRequest();
		loans.add(new_loan);
		totalLoans += new_loan.getAmount();
	}
	
	public void NewDepositR() {
		// The function creates a Deposit object and adds it to the the queue.
		
		UserRequest new_deposit = new UserRequest();
		deposits.add(new_deposit);
		totalDeposits += new_deposit.getAmount();
	}
	
	public void PayoutLoanR() {
		// The function deletes a Loan object from the end of the queue and subtracts the sum that needs to be paid from 'cash'.
		
		UserRequest payout = loans.remove();
		this.cash -= payout.getAmount();
		totalLoans -= payout.getAmount();
	}
	
	public void WithdrawDepositR() {
		// The function deletes a Loan object from the end of the queue and adds the sum that needs to be paid to 'cash'.
		
		UserRequest withdrawal = deposits.remove();
		this.cash += withdrawal.getAmount();
		totalDeposits -= withdrawal.getAmount();
	}
	
	public float GetCash() {
		return cash;
	}
	
	public float GetTotalLoans() {
		return totalLoans;
	}
	
	public float GetTotalDeposit() {
		return totalDeposits;
	}

}