package concurrency;

//: concurrency/MutexEvenGenerator.java
// Предотвращение потоковых конфликтов с использованием мьютексов.
// {RunByHand}

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();  // Ускоряем сбой
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }
}
