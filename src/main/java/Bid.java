public class Bid{

    private User user;
    private Item item;
    private int number;

    public Bid(User user, Item item, int num){
        this.user = user;
        this.item = item;
        this.number = num;
    }

    /**
     * Returns the number of the bid
     * @return int
     */
    public int getNumber(){
        return number;
    }

    /**
     * Returns the User that make the bid
     * @return User
     */
    public User getUser(){
        return user;
    }

    /**
     * Returns the Item that the bid was made for
     * @return Item
     */
    public Item getItem(){
        return item;
    }

}