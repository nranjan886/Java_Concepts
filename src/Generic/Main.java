package Generic;

public class Main {
    public static void main(String[] args) {

        var nationalPark = new Park[]{
                new Park("Waste of wander Park", "44.232, 231.233"),
                new Park("Manas Park", "98.232, 22.233"),
                new Park("PD Park", "91.232, 17.233")
        };

        Layer<Park> parkLayer = new Layer<>(nationalPark);
        parkLayer.renderLayer();

        var majorRiver = new River[]{
                new River("Ganga", "234.21, 23.123"),
                new River("Hindon", "63.21, 87.097"),
                new River("Kosi", "657.21, -083.123")
        };

        Layer<River> riverLayer = new Layer<>(majorRiver);
        riverLayer.renderLayer();
    }
}
