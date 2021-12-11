package multithreading;

import java.util.concurrent.*;

public class RunThreads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BattingStatisticsThread battingThread = new BattingStatisticsThread();
        battingThread.start();
        BowlingStatisticsThread bowlingStatisticsThread = new BowlingStatisticsThread();
        Thread bowlingThread = new Thread(bowlingStatisticsThread);
        bowlingThread.start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("executing thread from executor service" + Thread.currentThread().getName());
            }
        });
        System.out.println("End of the main");
        executorService.shutdown();

        executorService = Executors.newScheduledThreadPool(10);
        Future future = executorService.submit(bowlingStatisticsThread);
        System.out.println(future.get());


        future = executorService.submit(new Callable<Object>() {
            public String call() throws Exception {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("using callable " + Thread.currentThread().getName());
                }
                return "result";
            }
        });

        System.out.println("future from callable get " + future.get());

        executorService.shutdown();
    }


}
