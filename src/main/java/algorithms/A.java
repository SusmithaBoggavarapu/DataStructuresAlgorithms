package algorithms;

public class A {
    static int s1 = 1,s2 =2 ;
    public static void main(String[] args){
        float a = 1.2f;
        double d = 1.2;
        System.out.println(a==d);
        System.out.println(s1+s2);
        m1(null);
        A.call();

    }
    static void call(){
        System.out.println("so"+s1);
    }
    static void m1(String s){
        System.out.println("so");
    }
    static void m1(Object o){
        System.out.println("o");
    }

}
