package Abstract;

import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product){

}

public class Store {

    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {

        storeProducts.add(new ArtObject("Oil Painting", 1350, "Imp. work by Nitesh in 2024"));
        storeProducts.add(new ArtObject("Sculpture", 2000, "Bronze work by Nitesh in 1999"));

        listProduct();

        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1,1,2);
        addItemToOrder(order1,0,1);
        printOrder(order1);
    }

    public static void listProduct(){

        for (var item: storeProducts){
            System.out.println("_".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty){

        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){

        double salesTotal = 0;
        for (var item: order){
            item.product().printPriceItem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }
        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }
}
