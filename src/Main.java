import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count){
    public GroceryItem(String name){
        this(name, "Dairy",1);
    }
    @Override
    public String toString(){
        return String.format("%d %s in %s", count, name.toUpperCase(),type);
    }
}

public class Main {
    public static void main(String[] args) {

//        GroceryItem[] groceryArray = new GroceryItem[3];
//        groceryArray[0] = new GroceryItem("Milk");
//        groceryArray[1] = new GroceryItem("Food", "eat", 5);
//        groceryArray[2] = new GroceryItem("Kitkat", "Chocklet", 3);
//        System.out.println(Arrays.toString(groceryArray));

//        ArrayList objectList = new ArrayList();
//        objectList.add(new GroceryItem("Meat"));
//        objectList.add("Happy");

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Egg"));
        groceryList.add(new GroceryItem("Meat", "Food", 3));
        groceryList.set(0, new GroceryItem("Apple", "Fruit",5));
        groceryList.remove(1);
        System.out.println(groceryList);

    }
}