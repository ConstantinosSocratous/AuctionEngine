import java.util.ArrayList;

public class ItemsManager{

    private static ArrayList<Item> items = new ArrayList<>();

    public ItemsManager(){
    }

    /**
     * Clear all items
     */
    public static void clearItems(){
        items = new ArrayList<>();
    }

    /**
     * Returns all Items
     * @return ArrayList<Item>
     */
    public static ArrayList<Item> getItems(){
        return items;
    }

    /**
     * Adds item
     * @param item
     */
    public static void addItem(Item item){
        items.add(item);
    }

    /**
     * Returns an Item
     * @param name
     * @return Item
     */
    public static Item getItem(String name){
        for(Item item: items){
            if(item.getName().equals(name)) return item;
        }
        return null;
    }

    /**
     * Print all items
     */
    // public static void printAllItems(){
    //     System.out.println("ALL ITEMS");
    //     for(Item item: items){
    //         System.out.println(item.getName());
    //     }
    //     System.out.println();
    // }
}