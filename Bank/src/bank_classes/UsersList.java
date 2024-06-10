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
    public static void removeUser(User user) {
        users.remove(user);
    }

    // Get all users in the list
    public static LinkedList<User> getUsers() {
        return users;
    }

    // Other methods for managing users can be added as needed
}