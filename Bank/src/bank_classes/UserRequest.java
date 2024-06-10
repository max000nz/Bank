package bank_classes;
import java.util.UUID;

import enums.RequestType;

public class UserRequest {
	
	private UUID id = UUID.randomUUID();
	private int userId;
	private String message;
	private float amount;
	private RequestType type;

	public UserRequest(){}

	public UserRequest(int userId, String message, int amount , RequestType type ){
        
		this.userId = userId;
		this.message = message;
		this.amount = amount;
		this.type = type;
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

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}
