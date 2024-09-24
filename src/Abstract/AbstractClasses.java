package Abstract;

import java.util.ArrayList;

public class AbstractClasses {
    public static void main(String[] args) {

        Dog dog = new Dog("Wolf", "Big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("G.S", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Katla", "small", 2));

        for (Animal animal: animals){
            doAnimalStuff(animal);
        }
    }


    private static void doAnimalStuff(Animal animal){

        animal.makeNoise();
        animal.move("Slow");
    }
}
