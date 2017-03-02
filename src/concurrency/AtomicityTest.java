package concurrency;

//: concurrency/AtomicityTest.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
    private int i = 0;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest atomicity = new AtomicityTest();
        exec.execute(atomicity);

        while (true) {
            int val = atomicity.getValue();

            if (0 != val % 2) {
                System.out.println(val);
                System.exit(0);
            } else {
                System.out.println(".");
            }
        }
    }

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}
