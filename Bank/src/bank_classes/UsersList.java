package bank_classes;
import java.util.LinkedList;
import java.util.List;

import role_classes.User;

public class UsersList {
    private static LinkedList<User> users = new LinkedList<User>();

    // Add a user to the list
    public static void addUser(User user) {
        users.add(user);
    }

    // Remove a user from the list
    public static void removeUser(int user_id, int admin_id) {

        User temp_admin;

        for(User user_in_list : users){
            if(user_in_list.GetId() == admin_id) temp_admin = user_in_list;
            System.err.println("Only an admin perform this operation.");
            return;
        }

        for(User user_in_list : users){
            if(user_in_list.GetId() == user_id){
                users.remove(user_in_list);
                return;
            }
        }
        
    }

    // Get all users in the list
    public static LinkedList<User> getUsers() {
        return users;
    }

    // Other methods for managing users can be added as needed
}