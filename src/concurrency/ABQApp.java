package concurrency;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

    private BlockingQueue<String> drop;
    private List<String> messages = Arrays.asList(
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "Would't you eat ivy too?"
    );

    public Producer(BlockingQueue<String> d) {
        this.drop = d;
    }

    @Override
    public void run() {
        try {
            for (String s : messages)
                drop.put(s);
        } catch (InterruptedException e) {
            System.out.println("Interrupted! Last one out, turn out the lights!");
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<String> drop;

    public Consumer(BlockingQueue<String> d) {
        this.drop = d;
    }

    @Override
    public void run() {
        try {
            String msg;
            while (!(msg = drop.take()).equals("DONE"))
                System.out.println(msg);
        } catch (InterruptedException e) {
            System.out.println("Interrupted! Last one out, turn out the lights!");
        }
    }
}

public class ABQApp {
    public static void main(String[] args) {
        BlockingQueue<String> drop = new ArrayBlockingQueue<>(1, true);
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
