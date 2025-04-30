package edu.tucn.ispse.lecture10.ex8completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class CompletableFutureExample2 {
    public static void main(String[] args) {
        // simulate fetching data from a web service asynchronously
        CompletableFuture<String> webServiceFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("1. " + Thread.currentThread());
            return "Hello from web service!";
        });

        // simulate fetching data from a database asynchronously
        CompletableFuture<Integer> databaseFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("2. " + Thread.currentThread());
            return 10;
        });

        // combine the results of the two futures when they both complete
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(webServiceFuture, databaseFuture);

        // calculate the sum of the total length of the string and the integer value when both futures are complete
        combinedFuture.thenRun(() -> {
            String resultFromWebService = webServiceFuture.join();
            Integer resultFromDatabase = databaseFuture.join();
            int totalLength = resultFromWebService.length() + resultFromDatabase;
            System.out.println("3. " + Thread.currentThread());
            System.out.println("Total length: " + totalLength);
        });

        // wait for all tasks to complete
        combinedFuture.join();
    }
}
