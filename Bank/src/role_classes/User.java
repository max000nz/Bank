package role_classes;
import bank_classes.BankRequest;
import bank_classes.UserRequest;
import bank_classes.UsersList;
import enums.RequestType;
import enums.RoleType;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.UUID;

public class User extends Roles {
	
	private Stack<UserRequest> requestHistory;
	private Queue<UUID> loans;
	private Queue<UUID> deposits;
	
	private float frame = 0;
	private float cash= 0;
	private float totalLoans= 0;
	private float totalDeposits= 0;
	


	public User(){}

	public User(String name, String lastName, int id, String password, int cash, RoleType role) {
		
		super(name, lastName, id, password, role);
		
		requestHistory = new Stack<>();
		Queue<UUID> loans = new LinkedList<UUID>();
		Queue<UUID> deposits = new LinkedList<UUID>();

		
        this.cash = cash;
        this.totalLoans = 0;
        this.totalDeposits = 0;
    }

	public void NewLoanR(UserRequest loan) {
		// The function creates a Loan object and adds it to the the queue.
		loans.add(loan.getId());
		totalLoans += loan.getAmount();
		BankRequest.addRequest(loan);
	}
	
	public void NewDepositR(UserRequest deposit) {
		// The function creates a Deposit object and adds it to the the queue.
		deposits.add(deposit.getId());
		totalDeposits += deposit.getAmount();
		BankRequest.addRequest(deposit);
	}
	

	// The function deletes a Loan object from the end of the queue and subtracts the sum that needs to be paid from 'cash'.
	public void PayoutLoanR(UserRequest closeLoan) {
		this.cash -= closeLoan.getAmount();
		totalLoans -= closeLoan.getAmount();
		BankRequest.deleteRequest(closeLoan);
		this.loans.remove();
	}
	
	// The function deletes a Loan object from the end of the queue and adds the sum that needs to be paid to 'cash'.
	public void WithdrawDepositR(UserRequest closeDeposit) {
		this.cash += closeDeposit.getAmount();
		totalDeposits -= closeDeposit.getAmount();
		BankRequest.deleteRequest(closeDeposit);
		this.deposits.remove();
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

	public void SetFrame(float frame) {
		this.frame = frame;
	}

	public float GetFrame() {
		return frame;
	}

	public Queue<UUID> getLoans() {
		return loans;
	}

	public Queue<UUID> getDeposits() {
		return deposits;
	}

}