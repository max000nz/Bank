package bank_classes;
import enums.RoleType;
import java.util.LinkedList;
import role_classes.*;

public abstract class UsersList {

    private static LinkedList<Roles> users = new LinkedList<>();

    // Add a user to the list
    public static void addUser(Roles user) {
        users.add(user);
    }

    private static boolean validationAdmin(int admin_id){

        // Checks that only the admin is using the function
        for(Roles user_in_list : users){
            if(user_in_list.getId() == admin_id){
                if(user_in_list.getRole() == RoleType.USER){
                    System.err.println("\nOnly an admin perform this operation.");
                    return false;
                }
            }
        }
        return true;
    }

    // Remove a user from the list
    public static void removeUser(int user_id, int admin_id) throws Exception {

        if(validationAdmin(admin_id) == false){
            System.out.println("\nOnly an admin can perform this action");
            return;
        }
        // Removes the user with the corresponding id from the list
        for(Roles user_in_list : users){

            if(user_in_list.getId() == user_id){
                
                users.remove(user_in_list);
                return;
            }
        }

        throw new Exception("\nId was not found");
    }

    // Get all users in the list
    public static LinkedList<Roles> getUsers() {
        return users;
    }

    // Other methods for managing users can be added as needed
    
    public static User findUsertById(int id){
	  if (users.size() == 0) return null;
	  for (Roles curr : users) {
		   if(curr.getId() == id){
				return ((User)curr);
		   }
	  }
      return null;
  }


  public static  boolean checkIfexist(int id)
  {
    for (Roles elem :users ) {
        if(elem.getId()==id)
        return true;
    }
    return false;
  }
}