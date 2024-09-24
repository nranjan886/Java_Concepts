package Abstract;

public abstract class ProductForSale {

    protected String type;
    protected double price;
    protected String desc;

    public ProductForSale(String type, double price, String desc) {
        this.type = type;
        this.price = price;
        this.desc = desc;
    }

    public double getSalesPrice(int qty){
        return qty*price;
    }

    public void printPriceItem(int qty){
        System.out.printf("%2d qty at $%8.2f each, %-15s %-35s %n",
                qty, price, type, desc);
    }

    public abstract void showDetails();

}
