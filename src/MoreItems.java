import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MoreItems {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

//        String[] items = {"A", "B", "C", "D"};
//
//        List<String> list = List.of(items);
//        System.out.println(list);
//        ArrayList<String> itemsB = new ArrayList<>(list);
//        itemsB.add("E");
//        System.out.println(itemsB);
//
//        ArrayList<String> newItems = new ArrayList<>(List.of("X","Y","Z"));
//        itemsB.addAll(newItems);
//        System.out.println(itemsB);
//
//        System.out.println(itemsB.get(4));
//
//        itemsB.add("A");
//        System.out.println(itemsB.indexOf("A"));
//        System.out.println(itemsB.lastIndexOf("A"));
//        System.out.println(itemsB);

        boolean flag = true;
        ArrayList<String> groceries = new ArrayList<>();
        while(flag){
            printActions();
            switch (Integer.parseInt(sc.nextLine())){
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> flag = false;
            }
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }

    }

    private static void addItems(ArrayList<String> groceries){
        System.out.println("Add items [separate items by comma]:");
        String[] items = sc.nextLine().split(",");

        for (String i : items){
            String trimmed = i.trim();
            if(!groceries.contains(trimmed)){
                groceries.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceries){
        System.out.println("Remove items [separate items by comma]:");
        String[] items = sc.nextLine().split(",");

        for (String i : items){
            String trimmed = i.trim();
            groceries.remove(trimmed);
            }
        }

    private static void printActions(){
        String textBlock = """
                Available actions:
                0 - to shutdown
                1 - to add items to list (comma delimited list)
                2 - to remove any items (common delimited list)
                Enter a number for which action you want to do:""";
        System.out.print(textBlock + " ");
    }
}
