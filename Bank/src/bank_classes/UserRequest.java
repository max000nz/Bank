package bank_classes;
import java.util.UUID;

import enums.RequestType;

public class UserRequest {
	
	private UUID id = UUID.randomUUID();
	private int userId;
	private String message;
	private int amount;
	private RequestType type;

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
	public int getAmount() {
		return this.amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public UUID getId() {
		return this.id;
	}

	public int userId(){
		return this.userId;
	}

}
