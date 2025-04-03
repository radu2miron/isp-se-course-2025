package edu.tucn.ispse.lecture7.streamapi;

import java.util.Arrays;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex1IntStreamExample {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 1, 5, 6, 1, 2, 3, 4};

        int sum = Arrays.stream(array) // create an IntStream
                .filter(i -> i > 2) // keep numbers > 2
                .map(i -> i * 2) // multiply each number by 2
                .sum(); // compute the sum of the kept numbers multiplied by 2
        System.out.println(sum);

        System.out.println(Arrays.stream(array) // create an IntStream
                .summaryStatistics()); // get stream statistics

        Arrays.stream(array) // create an IntStream
                .distinct() // remove duplicates
                .limit(5) // keep only the first 5 numbers
                .forEach(System.out::println); // print each number

        Arrays.stream(array) // create an IntStream
                .sorted() // sort numbers
                .forEach(System.out::println); // print sorted numbers
    }
}
