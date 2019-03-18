import java.util.ArrayList;

public class UsersManager{

    private static ArrayList<User> users = new ArrayList<>();

    public UsersManager(){
        
    }

    /**
     * Clear all users
     */
    public static void clearUsers(){
        users = new ArrayList<>();
    }

    /**
     * Returns all User
     * @return ArrayList<User>
     */
    public static ArrayList<User> getUsers(){
        return users;
    }

    /**
     * Adds a user
     * @param user
     */
    public static void addUser(User user){
        users.add(user);
    }

    /**
     * Returns a User
     * @param name
     * @return User
     */
    public static User getUser(String name){
        for(User user: users){
            if(user.getName().equals(name)) return user;
        }
        
        return null;
    }

    /**
     * Print all users
     */
    // public static void printAllUsers(){
    //     System.out.println("ALL USERS");
    //     for(User user: users){
    //         System.out.println(user.getName());
    //     }
    //     System.out.println();
    // }
    
}