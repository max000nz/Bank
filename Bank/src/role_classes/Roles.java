package role_classes;
import javax.management.relation.Role;

import enums.RoleType;

public abstract class Roles {
	
protected String name;
protected String lastName;
protected String password;
protected int id;
protected RoleType role;


 // Set function can be done only for admin ( beacuse neet to change all the loans/deposite with)


//functions

public Roles(){}
public Roles(String name, String lastName, int id, String password, RoleType role)
{
	this.name = name;
	this.lastName = lastName;
	this.id = id;
	this.password = password;
	this.role = role;
}

public boolean SearchInfo(int id, String password)
{

	// create a connection to users DB (create bank-user class), get thw relevant user if exist 
	if(id == this.id && this.password.equals((password))) {
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

public int getId() {
	return id;
}

public void setId(int id){
	this.id = id;
}

public void setRole(RoleType role){
	this.role = role;
}

public void setPassword(String password){
  this.password = password;
}

}