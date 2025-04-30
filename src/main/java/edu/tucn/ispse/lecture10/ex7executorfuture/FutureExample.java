package edu.tucn.ispse.lecture10.ex7executorfuture;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed-size thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // List to store Future objects
        List<Future<String>> futureResults = new ArrayList<>();

        // Submit multiple tasks
        for (int i = 1; i <= 5; i++) {
            Future<String> future = executorService.submit(new MyCallableTask());
            futureResults.add(future);
        }

        // Do other work while tasks are running asynchronously

        // Retrieve results from Future objects
        for (Future<String> future : futureResults) {
            try {
                // Blocking call to get the result of each task
                String result = future.get();
                System.out.println("Task result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor when done
        executorService.shutdown();
    }
}

class MyCallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simulate some time-consuming task
        Thread.sleep(2000);

        return "Task completed by " + Thread.currentThread().getName();
    }
}

