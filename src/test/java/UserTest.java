import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest{

    @Before
    public void clear(){
        ItemsManager.clearItems();
        UsersManager.clearUsers();
    }

    @Test
    public void getAllBidsOnItemWithExtraUser(){
        Main main = new Main();
        main.addItem("toy");

        main.addUser("John");
        main.addUser("Marios");
        main.makeBid("John", "toy", 10);
        main.makeBid("Marios", "toy", 13);
        main.makeBid("John", "toy", 15);
        assertEquals(2, main.getBidsOnItemByUser("John", "toy").size());
        
    }

}