package role_classes;
import enums.RoleType;

public class Roles {
	
protected String name;
protected String lastName;
protected String password;
protected int id;
protected RoleType role;

// Empty-Constructor
public Roles(){}

// Non-empty Constructor
public Roles(String name, String lastName, int id, String password, RoleType role)
{
	this.name = name;
	this.lastName = lastName;
	this.id = id;
	this.password = password;
	this.role = role;
}

// Checks if the password that was entered is the correct password.
public boolean SearchInfo(int id, String password)
{
	if(id == this.id && this.password.equals((password))) {
		return true;
	}
	return false;
}

// Getters + Setters
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

public int getId() {
	return id;
}

public void setId(int id){
	this.id = id;
}

public void setRole(RoleType role){
	this.role = role;
}

public RoleType getRole(){
	return this.role;
}

public void setPassword(String password){
  this.password = password;
}

}