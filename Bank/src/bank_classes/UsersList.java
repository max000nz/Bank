package bank_classes;
import enums.RoleType;
import java.util.LinkedList;
import role_classes.*;

public class UsersList {

    private static LinkedList<Roles> users = new LinkedList<>();

    // Add a user to the list
    public static void addUser(User user) {
        users.add(user);
    }

    private static boolean validationAdmin(int admin_id){

        // Checks that only the admin is using the function
        for(Roles user_in_list : users){

            if(user_in_list.GetId() == admin_id){

                if(user_in_list.getRole() == RoleType.ADMIN){

                    System.err.println("Only an admin perform this operation.");
                    return true;
                }
            }
        }

        return false;
    }

    // Remove a user from the list
    public static void removeUser(int user_id, int admin_id) {

        if(!validationAdmin(admin_id)){
            System.out.println("Only an admin can perform this action");
            return;
        }

        // Removes the user with the corresponding id from the list
        for(Roles user_in_list : users){

            if(user_in_list.GetId() == user_id){
                
                users.remove(user_in_list);
                return;
            }
        }
    }

    // Get all users in the list
    public static LinkedList<Roles> getUsers() {
        return users;
    }

    // Other methods for managing users can be added as needed
}