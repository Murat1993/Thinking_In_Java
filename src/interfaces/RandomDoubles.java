//: interfaces/RandomDoubles.java
package interfaces;


import java.util.Random;

public class RandomDoubles {
    private static Random random = new Random(47);
    public double next() { return random.nextDouble(); }

    public static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 7; i++) {
            System.out.println(rd.next() + " ");
        }
    }
}
