package role_classes;

import bank_classes.BankRequest;
import bank_classes.UserRequest;

import enums.RoleType;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.UUID;

public class User extends Roles {
	
	private Stack<UserRequest> requestHistory;
	private Queue<UUID> loans = new LinkedList<>();
	private Queue<UUID> deposits = new LinkedList<>();
	
	private float frame = 0;
	private float cash= 0;
	private float totalLoans= 0;
	private float totalDeposits= 0;
	
	

	public User(){}

	public User(String name, String lastName, int id, String password, RoleType role) {
		
		super(name, lastName, id, password, role);
        this.totalLoans = 0;
        this.totalDeposits = 0;
    }

	// The function creates a Loan object and adds it to the the queue.
	public void NewLoanR(UserRequest loan) {
		BankRequest.addRequest(loan);
	}
	
	// The function creates a Deposit object and adds it to the the queue.
	public void NewDepositR(UserRequest deposit) {
		BankRequest.addRequest(deposit);
	}
	

	// The function deletes a Loan object from the end of the queue and subtracts the sum that needs to be paid from 'cash'.
	public void PayoutLoanR(UserRequest closeLoan) {
		closeLoan.setType(enums.RequestType.CLOSE_LOAN);
		BankRequest.addRequest(closeLoan);
	}
	
	// The function deletes a Loan object from the end of the queue and adds the sum that needs to be paid to 'cash'.
	public void WithdrawDepositR(UserRequest closeDeposit) {
		closeDeposit.setType(enums.RequestType.CLOSE_DEPOSIT);
		BankRequest.addRequest(closeDeposit);
	}

	public void setCash(float cash) {
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

	public void setTotalLoans(float totalLoans) {
		this.totalLoans = totalLoans;
	}

	public void setTotalDeposits(float totalDeposits) {
		this.totalDeposits = totalDeposits;
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

	public void addLoan(UUID newLoan) {
		if(loans.add(newLoan)){
			System.out.println("Loan added succesfully");
		}
	}

	public void addDeposit(UUID newDeposit) {
		if(deposits.add(newDeposit)){
			System.out.println("Deposit added succesfully");
		}
	}

	public void deleteLoan(UUID deleteLoan) {
		if(loans.remove(deleteLoan)){
			System.out.println("Loan deleted succesfully");
		}
	}

	public void deleteDeposit(UUID deleteDeposit) {
		if(deposits.remove(deleteDeposit)){
			System.out.println("Deposit deleted succesfully");
		}
	}

	public Queue<UUID> getDeposits() {
		return deposits;
	}

}