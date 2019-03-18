public class Main{


    public static void main(String[] args){

        Main main = new Main();
        main.addUser("John");
        main.addUser("Smith");
        main.addUser("Anderas");
        main.addUser("Maria");
        main.addUser("Anast");
        main.addUser("Con");
    }
    
    public Main(){
        
    }

    public void addUser(String name){
        UsersManager.addUser(new User(name));
    }

    public void addItem(String name){
        ItemsManager.addItem(new Item(name));
    }

    public void makeBid(String userName, String itemName, int number){
        if(UsersManager.getUser(userName) == null){
            System.out.println("User not found");
            return;
        } 

        UsersManager.getUser(userName).makeBid(itemName,number);
    }
}