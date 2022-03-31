package designpattern;

public class Singleton {
    public static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }

        }
        return singleton;

    }
}
