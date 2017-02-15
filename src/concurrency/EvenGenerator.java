package concurrency;

//: concurrency/EvenGenerator.java
// Конфликт потоков.

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue; // Опасная точка!
        Thread.yield();  // Ускоряем сбой
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
