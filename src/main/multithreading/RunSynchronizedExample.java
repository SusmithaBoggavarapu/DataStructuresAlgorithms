package MultiThreading;

import java.util.HashMap;
import java.util.concurrent.*;

public class RunSynchronizedExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int poolSize = 5;
        ExecutorService executorService = Executors.newScheduledThreadPool(poolSize);
        Future[] futures = new Future[poolSize];
        HashMap test = new HashMap();
        for (int i = 0; i < poolSize; i++) {
            int finalI = i;
            futures[i] = executorService.submit(new Callable<>() {
                public String call(){
                    test.put(finalI, "test");
                    System.out.println("executing thread:  " + Thread.currentThread().getName());
                    int threadId = (int) Thread.currentThread().getId();
                    String result = SynchronizedExample.getSum(10 + threadId,20 + threadId,30+ threadId);
                    return " thread id: " + threadId + " result: "+ result ;
                }
            });

        }

        for (int i = 0; i < poolSize; i++) {
            System.out.println("i: "+ i + " future: " + futures[i].get());
        }

        executorService.shutdown();
    }
}
