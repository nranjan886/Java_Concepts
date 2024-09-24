package Abstract;

public class Dog extends Animal {
    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed.equals("Slow")){
            System.out.println(type + " walking");
        }else {
            System.out.println(type + " running");
        }
    }

    @Override
    public void makeNoise() {
        if (type == "Wolf"){
            System.out.print("Howling! ");
        }else {
            System.out.print("Woof! ");
        }
    }
}
