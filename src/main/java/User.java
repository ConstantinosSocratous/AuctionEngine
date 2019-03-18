import java.util.ArrayList;
import java.util.HashSet;

public class User{

    private String name;
    private HashSet<Item> items;    // All the items that the user made bid

    public User(String username){
        items = new HashSet<>();
        this.name = username;    
    }

    /**
     * Makes a bid
     * @param itemName
     * @param number
     */
    public void makeBid(String itemName, int number){
        Item item = ItemsManager.getItem(itemName);

        if(item != null){
            Bid newBid = new Bid(this,item,number);
            if(item.addBid(newBid) == true){
                items.add(item);
                System.out.println("Bid made succesfully (" + this.name + ", " + itemName + ", " + number + ")");
            }else 
                System.out.println("Bid needs to be higher than the winning bid");
        }else 
            System.out.println("Item not found");

    }

    /**
     * Returns all the bids that the user made on a specific item
     * @param username
     * @return ArrayList<Bid>
     */
    public ArrayList<Bid> getAllBidsOnItem(String username){
        ArrayList<Bid> allBids = new ArrayList<>();
        Item item = ItemsManager.getItem(username);

        for(Bid bid: item.getBids()){
            if(bid.getUser().equals(this)){
                allBids.add(bid);
            }
        }
        return allBids;
    }

    /**
     * Prints all the bids that the user made on a specific item
     * @param username
     */
    // public void printAllBidsOnItem(String username){
    //     System.out.println("ALL BIDS THAT " + this.name +  " MADE ON ITEM " + username);
    //     ArrayList<Bid> bids = getAllBidsOnItem(username);
    //     for(Bid bid: bids){
    //         System.out.println("Bid: " + bid.getNumber());
    //     }
    // }

    /**
     * Prints all the items that the user made bid
     */
    // public void printAllItemsThatUserMadeBid(){
    //    System.out.println("ALL ITEMS THAT " + this.name +  " MADE BIDS");
    //    for(Item item: items){
    //        System.out.println("Item: " + item.getName());
    //    }
    // }

    /**
     * Returns all the items that the user made bid
     * @return HashSet<Item>
     */
    public HashSet<Item> getAllItemsThatUserMadeBid(){
        return items;
    }

    /**
     * Returns the name of the user
     * @return String
     */
    public String getName(){
        return name;
    }

 
}