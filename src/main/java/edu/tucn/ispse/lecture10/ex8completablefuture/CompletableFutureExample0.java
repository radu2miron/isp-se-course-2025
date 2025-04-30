package edu.tucn.ispse.lecture10.ex8completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class CompletableFutureExample0 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> new Random().nextInt(100)) // execute async
                .thenApply(r -> r * 3) // transform the result
                .thenApply(r -> "<" + r + ">") // transform the result
                .thenAccept(System.out::println) // print the result
                .join(); // wait for the final result and return it
    }
}
