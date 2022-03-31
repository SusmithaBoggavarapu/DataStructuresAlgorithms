package javapractise.oopsconcepts.abstraction;

public abstract class App {
    public static void main(String[] args) {
        int a;

    }

    public App() {

    }

    static void hello() {

    }
}

abstract class A {
    abstract void move();

    abstract void makeNoise();
}

abstract class B extends A {
    @Override
    void makeNoise() {

    }
}