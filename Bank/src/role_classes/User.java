package role_classes;
import bank_classes.UserRequest;
import enums.RequestType;
import enums.RoleType;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class User extends Roles {
	
	private Stack<UserRequest> requestHistory;
	private Queue<UserRequest> loans;
	private Queue<UserRequest> deposits;
	
	private float cash;
	private float totalLoans;
	private float totalDeposits;
	


	public User(){}

	public User(String name, String lastName, int id, String password, int cash, RoleType role) {
		
		super(name, lastName, id, password, role);
		
		requestHistory = new Stack<>();
		loans = new ArrayDeque<>();
		deposits = new ArrayDeque<>();

		
        this.cash = cash;
        this.totalLoans = 0;
        this.totalDeposits = 0;
    }
	
	public void NewLoanR(String message, int amount) {
		// The function creates a Loan object and adds it to the the queue.
		
		UserRequest new_loan = new UserRequest(id, message, amount, RequestType.LOAN);
		loans.add(new_loan);
		totalLoans += new_loan.getAmount();
	}
	
	public void NewDepositR(String message, int amount) {
		// The function creates a Deposit object and adds it to the the queue.
		
		UserRequest new_deposit = new UserRequest(id, message, amount, RequestType.DEPOSIT);
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

	public void SetCash(float cash) {
		this.cash = cash;
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

	public Stack<UserRequest> GetRequestHistory(){
		return requestHistory;
	}

}