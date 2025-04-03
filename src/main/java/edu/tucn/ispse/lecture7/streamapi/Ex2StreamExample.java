package edu.tucn.ispse.lecture7.streamapi;

import edu.tucn.ispse.lecture5.ex5record.ex53.Address;
import edu.tucn.ispse.lecture5.ex5record.ex53.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex2StreamExample {
    public static void main(String[] args) throws IOException {
        // filter -> map -> collect to a list
        List<String> names = Stream.of("Ana", "John", "Bella", "Zack", "Zoe", "Petru")
                .filter(name -> name.length() > 3) // keep only the names with a length > 3 chars
                .map(name -> name.toUpperCase()) // convert the names to upper case
                .toList(); // collect results to a list
        System.out.println(names);

        // filter -> map -> collect joining
        List<String> carBrands = Arrays.asList("Dacia", "ARO", "BMW", "Renault", "Alfa Romeo", "Bugatti");
        String cbJoined = carBrands.stream()
                .filter(cb -> cb.length() <= 7) // keep only the brands with a length < 7 chars
                .map(cb -> "[" + cb + "]") // add prefix '[' and suffix ']' to brands
                .collect(Collectors.joining("_")); // join the results into a String by using '_' as separator
        System.out.println(cbJoined);

        // read each line in file -> convert it to char array -> flat map -> collect to a char frequency map
        Map<Character, Long> characterFrequency =
                Files.lines(Path.of("testfiles/lorem_ipsum.txt")) // it returns a stream of String
                        .map(line -> line.chars()) // it returns a stream of IntStreams
                        .flatMap(intStream -> intStream.mapToObj(i -> (char) i)) // creates a single stream of Character (flat the streams)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // collect to a character frequency map
        System.out.println(characterFrequency);

        // filter -> sort -> print
        Stream.of(new Person("Mario", 25, new Address("1st New St.", "Doe City")),
                new Person("Mario", 12, new Address("3rd Old St.", "Gin Town")),
                new Person("Maia", 32, new Address("5th Blue Ave.", "New Town")),
                new Person("Ana", 15, new Address("4th Green Ave.", "Yellow City")),
                new Person("Mario", 21, new Address("21st Orange St.", "Odd City")))
                .filter(person -> person.name().startsWith("M")) // keep persons with names starting 'M'
                .sorted(Comparator.comparing(Person::name).thenComparing(Person::age)) // sort by name then by age
                .forEach(System.out::println); // print each person
    }
}
