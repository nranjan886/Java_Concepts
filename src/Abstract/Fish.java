package Abstract;

public class Fish extends Animal {
    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equals("Slow")){
            System.out.println(type + " lazily swimming");
        }else {
            System.out.println(type + " daring frantically");
        }
    }

    @Override
    public void makeNoise() {
        if (type == "Goldfish"){
            System.out.print("swish! ");
        }else {
            System.out.print("splash! ");
        }
    }
}
