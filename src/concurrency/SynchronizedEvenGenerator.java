package concurrency;

//: concurrency/SynchronizedEvenGenerator.java
// Упрощение работы с мьютексами с использованием
// ключевого слова synchronized.
// {RunByHand}

public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield(); //  Ускоряем сбой
        ++currentEvenValue;

        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
