import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MainTest{

    @Before
    public void clear(){
        ItemsManager.clearItems();
        UsersManager.clearUsers();
    }

    @Test
    public void addItem(){
        Main main = new Main();
        main.addItem("ball");
        assertEquals(ItemsManager.getItems().size(),1);
    }

    @Test
    public void getItem(){
        Main main = new Main();
        main.addItem("ball");
        assertEquals(main.getItem("ball").getName(),"ball");
    }

    @Test
    public void addUser(){
        Main main = new Main();
        main.addUser("John");
        assertEquals(UsersManager.getUsers().size(),1);
    }

    @Test
    public void getUser(){
        Main main = new Main();
        main.addUser("John");
        assertEquals(main.getUser("John").getName(),"John");
    }

    @Test
    public void makeBidCorrectly(){
        Main main = new Main();
        main.addItem("ball");
        main.addUser("Smith");
        main.makeBid("Smith", "ball", 50);
        assertEquals(1,main.getBidsOfItem("ball").size());
    }

    @Test
    public void makeBidWithNoUser(){
        Main main = new Main();
        main.addItem("xbox");
        main.makeBid("Marios", "xbox", 50);
        assertEquals(0,main.getBidsOfItem("xbox").size());
    }

    @Test
    public void makeBidWithNoItem(){
        Main main = new Main();
        main.addUser("John");
        main.makeBid("John", "toy", 50);
        assertEquals(null, main.getBidsOfItem("toy"));
    }

    @Test
    public void makeBidWithLessOrLowestNumber(){
        Main main = new Main();
        main.addUser("John");
        main.addItem("toy");
        main.makeBid("John", "toy", 50);
        main.makeBid("John", "toy", 50);
        assertEquals(1, main.getBidsOfItem("toy").size());
    }

    @Test
    public void getWinningBidCorrectly(){
        Main main = new Main();
        main.addUser("Con");
        main.addUser("Marios");
        main.addItem("toys");

        main.makeBid("Con", "toys", 50);
        main.makeBid("Marios", "toys", 80);
        assertEquals("Marios", main.getWinningBid("toys").getUser().getName());
    }

    @Test
    public void getWinningBidWhenThereIsNot(){
        Main main = new Main();
        main.addItem("toys");
        assertEquals(null, main.getWinningBid("toys"));
    }

    @Test
    public void getWinningBidWhenThereIsNoItem(){
        Main main = new Main();
        assertEquals(null, main.getWinningBid("toys"));
    }

    @Test
    public void getItemsThatUserMadeBidCorrectly(){
        Main main = new Main();
        main.addItem("toy");
        main.addItem("ball");

        main.addUser("John");
        main.makeBid("John", "toy", 10);
        main.makeBid("John", "ball", 10);

        assertEquals(2, main.getItemsThatUserMadeBid("John").size());
    }

    @Test
    public void getItemsThatUserMadeBidWithNoUser(){
        Main main = new Main();
        main.addItem("toy");
        main.addItem("ball");
        assertEquals(null, main.getItemsThatUserMadeBid("John"));
    }

    @Test
    public void getBidsOnItemByUserCorrect(){
        Main main = new Main();
        main.addItem("toy");

        main.addUser("John");
        main.makeBid("John", "toy", 10);
        main.makeBid("John", "toy", 15);
        assertEquals(2, main.getBidsOnItemByUser("John", "toy").size());
    }

    @Test
    public void getBidsOnItemByUserItemNull(){
        Main main = new Main();
        main.addUser("John");
        assertEquals(null, main.getBidsOnItemByUser("John", "toy"));
    }

    @Test
    public void getBidsOnItemByUserUserNull(){
        Main main = new Main();
        main.addItem("toy");

        main.addUser("John");
        main.makeBid("John", "toy", 10);
        main.makeBid("John", "toy", 15);

        assertEquals(null, main.getBidsOnItemByUser("Smith", "toy"));
    }
    

}

