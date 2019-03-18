import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BidTest{

    @Before
    public void clear(){
        ItemsManager.clearItems();
        UsersManager.clearUsers();
    }

    @Test
    public void getItem(){

        Item item = new Item("ball");
        Bid bid = new Bid(new User("John"),item,10);

        assertEquals(item, bid.getItem());
    }
}