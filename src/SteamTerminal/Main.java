package SteamTerminal;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        var result =
                IntStream
                        .iterate(0, i-> i <= 1000, i-> i = i + 3)
                        .summaryStatistics();
        System.out.println("Result = " + result);

        var leapYearData = IntStream
                .iterate(2000, i -> i <= 2025, i -> i = i+1)
                .filter(i-> i % 4 == 0)
                .peek(System.out::println)
                .summaryStatistics();
        System.out.println("Leap Year Data = "+ leapYearData);

    }
}
