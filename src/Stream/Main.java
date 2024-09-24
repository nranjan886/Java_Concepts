package Stream;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        int seed = 1;
        var streamB = Stream.iterate(seed, i-> i <=15, i-> i+1)
                .map(i-> "B" + i);

        seed += 15;
        var streamI = Stream.iterate(seed, i-> i+1)
                        .limit(15)
                                .map(i-> "I"+i);

        seed += 15;
        int nSeed = seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i->"N"+(nSeed + i));
        var streamN = Arrays.stream(oLabels);

        var stearmNB = Stream.concat(streamN, streamB);
        Stream.concat(stearmNB, streamI)
                .forEach(System.out::println);

        System.out.println("--------------------------------------");

        Stream.generate(()-> new Random().nextInt(nSeed, nSeed+15))
                .distinct()
                .limit(15)
                .map(i->"O"+i)
                .sorted()
                .forEach(System.out::println);


        IntStream.iterate((int) 'A', i-> i <= (int) 'z', i-> i+1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
//                .dropWhile(i-> Character.toUpperCase(i) <='E')
//                .takeWhile(i -> i < 'a')
//                .skip(5)
//                .filter(i-> Character.toUpperCase(i) > 'E')
                .forEach(d->System.out.printf("%c ", d));

        System.out.println();
        Random random = new Random();

        Stream.generate(()->random.nextInt((int)'A', (int) 'Z' + 1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d-> System.out.printf("%c ", d));

        System.out.println();
        int maxSeats = 100;
        int seatsInRow = 10;
        var steam = Stream.iterate(0, i-> i < maxSeats, i -> i+1)
                .map(i-> new Seat((char)('A' + i / seatsInRow) ,
                i% seatsInRow + 1))
                .skip(5)
                .limit(10)
                .peek(s-> System.out.println("--> " + s))
                .sorted(Comparator.comparing(Seat::price)
                        .thenComparing(Seat::toString));
//                .mapToDouble(Seat::price)
//                .boxed()
//                .map("%.2f"::formatted);

        steam.forEach(System.out::println);





    }
}
