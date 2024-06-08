public class Roles {
private String name;
private String lastName;
private String Password;
static int id=0;

private enum roleType {
User, 
Admin;
}
  


//functions
public Roles()
{
	id=id+1;
}

public boolean SearchInfo(int id, String Password)
{

return true;
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

public String getPassword() {
return Password;
}

public void setPassword(String password) {
Password = password;
}

}