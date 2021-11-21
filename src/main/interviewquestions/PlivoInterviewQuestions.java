public class PlivoInterviewQuestions {
    public static void main(String[] args){
        int x = -1, y =1;
        System.out.println((x<0)^(y<0));
        //3 -  COLD
        //5 - DRINK
        //3*5 - COLD -DRINK
        // 1- 100

        for (int i = 1; i < 100; i++) {
            if(isMultipleOf(i,15)){
                System.out.println(i+ " COLD - DRINK");
                continue;
            }
            if(isMultipleOf(i,5)){
                System.out.println(i+" DRINK");
                continue;
            }
            if(isMultipleOf(i,3)) {
                System.out.println(i + " COLD");
                continue;
            }
        }


        try{
            isMultipleOf(100,10);
            return;
        }catch (Exception e){
            System.out.println(100+" Catch");
        }finally {
            System.out.println("new");
        }

        System.out.println("hey");


    }
    public static boolean isMultipleOf(int ip, int factor){
        return  ip%factor == 0;
    }


}

 class A{
    double add(int a, int b)  throws  RuntimeException{return a+b;}
}
abstract class B extends A {
    double add(int a, int b) { return a+b;}
     final int two(){
        return 1;
    }
}

