import java.util.ArrayList;

public class Item{

    private ArrayList<Bid> bids;
    private String name;

    public Item(String name){
        bids = new ArrayList<>();
        this.name = name;
    }

    public Boolean addBid(Bid bid){
        if(isBidValid(bid)){
            bids.add(bid);
            return true;
        }
        else return false;
    }

    public Boolean isBidValid(Bid bid){
        if(getWinningBid()!=null){
            if(bid.getNumber() > getWinningBid().getNumber()) return true;
            else return false;
        }else{
            return true;
        }
        
    } 

    public Bid getWinningBid(){
        int max = 0;
        Bid temp = null;

        for(Bid bid: bids){
            if(bid.getNumber() > max){
                max = bid.getNumber();
                temp = bid;
            }
        }
        return temp;
    }

    public ArrayList<Bid> getBids(){
        return bids;
    }

    public String getName(){
        return name;
    }

    public void printBids(){
        System.out.println("BIDS FOR ITEM " + name);
        Bid winningBid = getWinningBid();
        System.out.println("Winning Bid: " + winningBid.getUser().getName() + " --> "+ winningBid.getNumber());
        for(Bid bid: bids){
            System.out.println("User " + bid.getUser().getName() + " --> " + bid.getNumber());
        }
    }

}
