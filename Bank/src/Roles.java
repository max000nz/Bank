


public class Roles {
private String name;
private String lastName;
private String password;
private int id;

private enum roleType{
USER, 
ADMIN;
}


// set function can be done only for admin ( beacuse neet to change all the loans/deposite with)


//functions
public Roles(String name, String lastName, int id, String password)
{
	this.name = name;
	this.lastName = lastName;
	this.id = id;
	this.password = password;
}

public boolean SearchInfo(int id, String password)
{

	// create a connection to users DB (create bank-user class), get thw relevant user if exist 
	if(id == this.id && password == this.password) {
		return true;
	}
	return false;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) { 
	this.lastName = lastName;
}

public int GetId() {
	return id;
}

}