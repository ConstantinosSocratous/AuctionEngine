import java.util.ArrayList;
import java.util.HashSet;

public class User{

    private String name;
    private HashSet<Item> items;

    public User(String username){
        items = new HashSet<>();
        this.name = username;    
    }

    public void makeBid(String name, int number){
        Item item = ItemsManager.getItem(name);

        if(item != null){
            Bid newBid = new Bid(this,item,number);
            if(item.addBid(newBid) == true){
                items.add(item);
                System.out.println("Bid made succesfully");
            }else 
                System.out.println("Bid needs to be higher than the winning bid");
        }else 
            System.out.println("Item not found");

    }

    public ArrayList<Bid> getAllBidsOnItem(String name){
        ArrayList<Bid> allBids = new ArrayList<>();
        Item item = ItemsManager.getItem(name);

        for(Bid bid: item.getBids()){
            if(bid.getUser().equals(this.name)){
                allBids.add(bid);
            }
        }
        return allBids;
    }

   public void printAllItemsThatUserMadeBid(){
       System.out.println("ALL ITEMS THAT " + this.name +  " MADE BIDS");
       for(Item item: items){
           System.out.println("Item: " + item.getName());
       }
   }

    public HashSet<Item> getAllItemsThatUserMadeBid(){
        return items;
    }

    public String getName(){
        return name;
    }

}