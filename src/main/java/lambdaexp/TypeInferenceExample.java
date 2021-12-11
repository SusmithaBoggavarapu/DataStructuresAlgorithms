package lambdaexp;

public class TypeInferenceExample {
    public static void main(String[] args){
        StringLengthLamba myLamba = s -> s.length();
        System.out.println(myLamba.getLength("Hello Lamba"));
        printLambda(s-> s.length());
    }

    static void printLambda(StringLengthLamba l){
        System.out.println(l.getLength("Hello Lamba!"));
    }
    //interface has method signature i.e. return type and parameters
    interface StringLengthLamba{
        int getLength(String s);
    }
}
