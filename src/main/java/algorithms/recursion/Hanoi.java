package algorithms.recursion;

public class Hanoi {
    public static void main(String[] args) {
        moveRods(3, "A", "B", "C");
    }

    public static void moveRods(int n, String fromRod, String toRod, String auxRod) {
        if (n == 1) {
            System.out.println("moved disk: " + n + " from: " + fromRod + " to: " + toRod );
            return;
        }
        moveRods(n - 1, fromRod, auxRod, toRod);
        System.out.println("moved disk: " + n + " from: " + fromRod + " to: " + toRod);
        moveRods(n - 1, auxRod, toRod, fromRod);

    }
}
