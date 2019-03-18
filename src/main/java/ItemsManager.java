import java.util.ArrayList;

public class ItemsManager{

    private static ArrayList<Item> items = new ArrayList<>();

    public ItemsManager(){
    }

    public static void addItem(Item item){
        items.add(item);
    }

    public static Item getItem(String name){
        for(Item item: items){
            if(item.getName().equals(name)) return item;
        }
        return null;
    }
    public static void printAllItems(){
        System.out.println("ALL ITEMS");
        for(Item item: items){
            System.out.println(item.getName());
        }
        System.out.println();
    }
}