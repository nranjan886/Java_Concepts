package Lambda_Exp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {

    record Person(String firstName, String lastName){
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Main.Person("Sitesh", "Ranjan"),
                new Person("Sannu", "Kumar"),
                new Person("Karan", "Kaushal"),
                new Person("Nitesh", "Ranjan"))
        );



        // Over here we are passing anonymous class inside the variable
//        var comparatorLastName = new Comparator<Person>(){
//
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.lastName().compareTo(o2.lastName());
//            }
//        };

        // Lambda expression implemented.
        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));

        System.out.println(people);


        interface EnhancedCopmaprator<T> extends Comparator<T>{
            int secondLevel(T o1, T o2);
        }

        var compareToMixed = new EnhancedCopmaprator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return ( result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };

        people.sort(compareToMixed);
        System.out.println(people);

        List<String> list = new ArrayList<>(List.of(
                "Alpha", "bravo", "Charlie", "de lta"
        ));

        list.forEach((var s)-> System.out.println(s));

        int result = calculator((a, b)-> a + b, 3, 5);

    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of Operation: " + result);
        return result;
    }
}
