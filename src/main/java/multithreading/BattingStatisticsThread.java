package multithreading;

public class BattingStatisticsThread extends Thread{

    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("running batting statistics thread" + Thread.currentThread().getName());
        }
    }
}
