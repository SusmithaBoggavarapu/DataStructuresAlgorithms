package multithreading;

public class SynchronizedExample {
    static int cell1,cell2,cell3;
    public static String getSum(int a,int b, int c){
        System.out.println("input is a: " + a+ " b: "+b +" c: "+c);
        cell1 = a;
        sleepForSomeTime();
        cell2 = b;
        sleepForSomeTime();
        cell3 = c;
        sleepForSomeTime();

        return " " + cell1 + cell2 + cell3;
    }

    static void sleepForSomeTime(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void synchronizedBlockExample() {
        synchronized (this){
            System.out.println("synchronized block example");
        }
    }

    synchronized void synchronizedMethodExample(){
        System.out.println("synchronized method example");
    }

    synchronized static void staticSynchronizedMethod(){
        System.out.println("synchronized static method");
    }
}
