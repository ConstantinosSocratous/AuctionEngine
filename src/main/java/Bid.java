public class Bid{

    private User user;
    private Item item;
    private int number;

    public Bid(User user, Item item, int num){
        this.user = user;
        this.item = item;
        this.number = num;
    }

    public int getNumber(){
        return number;
    }

    public User getUser(){
        return user;
    }

    public Item getItem(){
        return item;
    }

}