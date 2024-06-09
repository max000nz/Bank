
public class UserRequest {
	
	private int loans;
	private int id;
	private String message;
	private int amount;
    private enum requestType {
      LOAN, 
      DEPOSITE,
	  SET_NAME,
	  SET_LAST_NAME,
}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLoans() {
		return loans;
	}
	public void setLoans(int loans) {
		this.loans = loans;
	}
	
}
