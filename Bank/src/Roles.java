public class Roles {
private String name;
private String lastName;
private String password;
private int id;

private enum roleType {
User, 
Admin;
}

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

}