//: concurrency/BasicThreads.java
// Простейший вариант использования класса Thread..
package concurrency;


public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
