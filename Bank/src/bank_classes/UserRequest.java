package bank_classes;
import enums.RequestType;
import java.util.UUID;

public class UserRequest {
	
	private UUID id = UUID.randomUUID();
	private int userId;
	private String message;
	private float amount;
	private RequestType type;
	private int interest;
	public UserRequest(){}

	public UserRequest(int userId, String message, int amount, int interest , RequestType type ){
        
		this.userId = userId;
		this.message = message;
		this.amount = amount;
		this.interest = interest;
		this.type = type;
	}

	public void calculateInterest(float cash){
		int calc = (int)cash/1000;
			if(calc == 0){
				this.interest = 1;
			}else{
				this.interest = calc;
			}
	}

	public String getMessage() {

		return this.message;

	}
	public void setMessage(String message) {
		this.message = message;
	}
	public float getAmount() {
		return this.amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public UUID getId() {
		return this.id;
	}

	public void setUserId(int user){
		this.userId = user;
	}

	public int getUserId(){
		return this.userId;
	}

	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }
}
