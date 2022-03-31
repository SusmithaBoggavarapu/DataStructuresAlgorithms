package javapractise.multithreading;

public class BowlingStatisticsThread implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println("running bowling statistics thread" + Thread.currentThread().getName());
        }

    }
}
