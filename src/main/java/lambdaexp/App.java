package lambdaexp;

public class App {
    public static void main(String[] args){
        Greeter greeter = new Greeter();
        //instance of a class
        HelloWorldGreeting helloWorldGreeting  = new HelloWorldGreeting();
        greeter.greet(helloWorldGreeting);

        //(anonymous class without class name)
        Greeting innerClassGreeting = new Greeting(){
            @Override
            public void perform() {
                System.out.println("HelloWorld!");
            }
        };

        innerClassGreeting.perform();
        //(or)
        greeter.greet(innerClassGreeting);

        //type inference, the lambda expression types are inferred as Greeting
        greeter.greet(()-> System.out.println("hello"));

        //lambda expression with Greeting interface (another way creating anonymous function)
        MyLambda myLambdaExp = () -> System.out.println("hello");


        MyDouble doubleNumberFun = (int a) -> a * 2;
        MyAdd addFunction = (int a, int b) -> a+b ;
        MyAdd safeDivideFunc = (int a, int b) -> {
            if(b == 0) return  0;
            return  a/b;
        } ;
        //strLengthCnt = (String str) -> str.length();

        Greeting myLambdaEx = () -> System.out.println("hello");
        myLambdaEx.perform();
        //(or) another way
        greeter.greet(myLambdaEx);

        Greeting hello = new HelloWorldGreeting();
        hello.perform();

        Runnable run = () -> System.out.println("running thread");
        Thread myThread = new Thread(run);
        myThread.start();

    }
}
interface MyLambda{
    void foo();
}
interface MyDouble{
    int foo(int a);

}
interface MyAdd{
    int add(int a,int b);
}

class Greeter{
    public void greet(Greeting greeting) {
       greeting.perform();
    }
}
// all the methods in the interface are public by default
// all the variables are public, static and final by default
//functional interface enforces to have only one method but its not mandatory for lamba expressions

@FunctionalInterface
interface Greeting{
    String s= "hello";
    void perform();
    //default is public
    default void random(){

    }
}

class HelloWorldGreeting implements Greeting{
    @Override
    public void perform(){
        System.out.println("Hello World!");
    }
}