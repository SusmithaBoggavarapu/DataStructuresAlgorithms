package javapractise.multithreading.calculator;

class Calculator extends Thread {
    long sum;
    public void run(){
        synchronized (this){
            for (int i = 0; i < 100000; i++) {
                sum += i;
            }
            notify();
        }
    }
}

public class ThreadWaitAndNotify{
public static void main(String[] args) throws InterruptedException {
    Calculator thread = new Calculator();
    thread.start();
    synchronized (thread){
        thread.wait();
    }
    System.out.println(thread.sum);
}
}
