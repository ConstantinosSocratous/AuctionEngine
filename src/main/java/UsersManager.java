import java.util.ArrayList;

public class UsersManager{

    private static ArrayList<User> users = new ArrayList<>();

    public UsersManager(){
        
    }

    public static void addUser(User user){
        users.add(user);
    }

    public static User getUser(String name){
        for(User user: users){
            if(user.getName().equals(name)) return user;
        }
        
        return null;
    }

    public static void printAllUsers(){
        System.out.println("ALL USERS");
        for(User user: users){
            System.out.println(user.getName());
        }
        System.out.println();
    }
    
}