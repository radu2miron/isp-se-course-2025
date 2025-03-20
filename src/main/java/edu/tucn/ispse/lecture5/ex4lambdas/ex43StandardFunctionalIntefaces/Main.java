package edu.tucn.ispse.lecture5.ex4lambdas.ex43StandardFunctionalIntefaces;

import java.util.function.Predicate;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Main {
    public static void main(String[] args) {
        Computer[] computers = {
                new Computer(2024, 4, "Dell"),
                new Computer(2021, 4, "Asus"),
                new Computer(2023, 6, "HP"),
                new Computer(2022, 1, "Acer"),
                new Computer(2024, 8, "Toshiba"),
                new Computer(2020, 8, "Acer"),
        };

        // Example 1: OwnFilter implemented as anonymous class. Filter by manufacturing year.
        OwnFilter filterByYear = new OwnFilter() {
            @Override
            public boolean doFilter(Computer computer) {
                return computer.getYearOfManufacturing() > 2022;
            }
        };
        printComputersWithOwnFilter(computers, filterByYear);

        // Example 2: (Example 1 reimplemented) OwnFilter implemented as a lambda. Filter by manufacturing year.
        printComputersWithOwnFilter(computers, computer -> computer.getYearOfManufacturing() > 2022);

        // Example 3: Lambda - filter by year and num. of cores
        printComputersWithOwnFilter(computers,
                computer -> computer.getYearOfManufacturing() > 2021 && computer.getNumberOfCores() >= 6);

        // FOR FILTERING OPERATIONS JAVA PROVIDES A STANDARD FUNCTIONAL INTERFACE: Predicate<T> with method test(T t)
        // THERE'S NO NEED TO DEFINE A CUSTOM OwnFilter INTERFACE

        // Example 4: Lambda with Predicate - filter by producer
        printComputersWithPredicate(computers, computer -> computer.getProducer().equals("Acer"));

        // Example 5: Lambda with Predicate - filter by all attributes
        printComputersWithPredicate(computers,
                computer -> computer.getProducer().equals("Acer")
                        && computer.getNumberOfCores() == 1
                        && computer.getYearOfManufacturing() < 2025);

    }

    public static void printComputersWithOwnFilter(Computer[] computers, OwnFilter filter) {
        System.out.println("Filtered computers:");
        for (Computer computer : computers) {
            if (filter.doFilter(computer)) {
                System.out.println(computer);
            }
        }
        System.out.println();
    }

    public static void printComputersWithPredicate(Computer[] computers, Predicate<Computer> predicate) {
        System.out.println("Filtered computers:");
        for (Computer computer : computers) {
            if (predicate.test(computer)) {
                System.out.println(computer);
            }
        }
        System.out.println();
    }
}
