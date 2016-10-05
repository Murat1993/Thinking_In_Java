package concurrency;

//: concurrency/SleepingTask.java
// Вызов sleep() для приостановки потока.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                // Старый стиль.
                // Thread.sleep(100);
                // Стиль Java SE5/6:
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
