
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorSimple {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Input: numbers to square
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // TODO 1: Create a fixed thread pool with 3 threads
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<Integer> future = pool.submit(()->{
            System.out.println("Yay!");
            Thread.sleep(10000);
            return 2;
        });
        Thread.sleep(11000);
        System.out.println("About to call get!");
        int value = future.get();
        System.out.println(value);
        
        /* 
        // TODO 2: Submit a task for each number
        List<Future<Integer>> futures = new ArrayList<>();

        for (Integer num : numbers) {
            // TODO: Submit a task that returns num * num
            Future<Integer> future = null;
            futures.add(future);
        }

        // TODO 3: Collect the results
        System.out.println("Squared values:");
        for (Future<Integer> future : futures) {
            // TODO: Print the result of future.get()
        }
            */

        // TODO 4: Shutdown the pool
        pool.shutdown();
    }
}
