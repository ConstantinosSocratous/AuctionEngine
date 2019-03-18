import java.util.ArrayList;
import java.util.HashSet;

public class Main{

    public static void main(String[] args){

        // Main main = new Main();
        // main.addUser("John");
        // main.addUser("Smith");
        // main.addUser("Andreas");
        // main.addUser("Maria");
        // main.addUser("Anast");
        // main.addUser("Con");


        // main.addItem("Ball");
        // main.addItem("xbox");
        // main.addItem("toy");
        // main.addItem("test");
        

        // main.makeBid("Smith", "test", 10);
        // main.makeBid("Andreas", "test", 15);
        // main.makeBid("Con", "Ball", 15);
        // main.makeBid("Andreas", "Ball", 16);
        // main.makeBid("Andreas", "Ball", 17);
        // main.makeBid("Andreas", "Ball", 18);
        // main.makeBid("Con", "Ball", 20);
        // // main.makeBid("Smith", "test", 10);
        // // main.makeBid("Andreas", "test", 10);


        // main.getWinningBid("Ball");
        // main.getBidsOfItem("Ball");
        // main.getBidsOfItem("test");


        // main.getItemsThatUserMadeBid("Con");
        // main.getItemsThatUserMadeBid("Andreas");
        // main.getBidsOnItemByUser("Andreas", "test");
    }
    
    public Main(){
        
    }

    /**
     * Adds a user to the Users Manager
     * @param name
     */
    public void addUser(String name){
        UsersManager.addUser(new User(name));
    }

    /**
     * Returns a User
     * @param name
     * @return User
     */
    public User getUser(String name){
        return UsersManager.getUser(name);
    }

    /**
     * Adds an Item to the Items Manager
     * @param name
     */
    public void addItem(String name){
        ItemsManager.addItem(new Item(name));
    }

    /**
     * Returns an Item
     * @param name
     * @return Item
     */
    public Item getItem(String name){
        return ItemsManager.getItem(name);
    }


    /**
     * Makes a bid
     * @param userName
     * @param itemName
     * @param number
     */
    public void makeBid(String userName, String itemName, int number){
        User user = UsersManager.getUser(userName);
        if(user == null){
            System.out.println("User not found");
            return;
        } 

        user.makeBid(itemName,number);
    }

    /**
     * Returns Winning Bid of an Item
     * @param itemName
     * @return Bid
     */
    public Bid getWinningBid(String itemName){
        Item item = ItemsManager.getItem(itemName);
        if(item == null){
            System.out.println("Item not found");
            return null;
        } 

        Bid winningBid = item.getWinningBid();
        if(winningBid == null)  return null;
        else System.out.println("Item : " + itemName + " user: " + winningBid.getUser().getName() + " --> " + winningBid.getNumber());
        return winningBid;
    }

    /**
     * Returns all bids of an Item
     * @param itemName
     * @return ArrayList<Bid>
     */
    public ArrayList<Bid> getBidsOfItem(String itemName){
        Item item = ItemsManager.getItem(itemName);
        if(item == null){
            System.out.println("Item not found");
            return null;
        } 
        //item.printBids();
        return item.getBids();
    }

    /**
     * Returns all Bids that a user made on a specific Item
     * @param userName
     * @param itemName
     * @return ArrayList<Bid>
     */
    public ArrayList<Bid> getBidsOnItemByUser(String userName, String itemName){
        Item item = ItemsManager.getItem(itemName);
        if(item == null){
            System.out.println("Item not found");
            return null;
        }

        User user = UsersManager.getUser(userName);
        if(user == null){
            System.out.println("User not found");
            return null;
        } 
        
        //user.printAllBidsOnItem(itemName);
        return user.getAllBidsOnItem(itemName);
    }

    /**
     * Returns all Items that a user made bids.
     * @param userName
     * @return HashSet<Item>
     */
    public HashSet<Item> getItemsThatUserMadeBid(String userName){

        User user = UsersManager.getUser(userName);
        if(user == null){
            System.out.println("User not found");
            return null;
        }

        //user.printAllItemsThatUserMadeBid();
        return user.getAllItemsThatUserMadeBid();
    }

}