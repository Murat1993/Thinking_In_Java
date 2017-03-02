package concurrency;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;

class Race {
    private Random random = new Random();

    public int getDistance() {
        return distance;
    }

    private int distance = random.nextInt(250);
    private CountDownLatch start;
    private CountDownLatch finish;

    private List<String> horses = new ArrayList<>();

    public Race(String... names) {
        this.horses.addAll(Arrays.asList(names));
    }

    public void run() throws InterruptedException {
        System.out.println("And the horses are stepping up to the gate...");
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch finish = new CountDownLatch(horses.size());
        final List<String> places = Collections.synchronizedList(new ArrayList<String>());

        for (final String h : horses) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(h + " stepping up to the gate...");
                        start.await();

                        int traveled = 0;
                        while (traveled < distance) {
                            // через 0-2 секунды...
                            Thread.sleep(random.nextInt(3) * 1000);

                            // ... лошадь проходит дистанцию 0-14 пунктов
                            traveled += random.nextInt(15);
                            System.out.println(h + " advanced to " + traveled + "!");
                        }

                        finish.countDown();
                        System.out.println(h + " crossed the finish!");
                        places.add(h);

                    } catch (InterruptedException e) {
                        System.out.println("ABORTING RACE!!!");
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println("And... they're off!");
        start.countDown();

        finish.await();
        System.out.println("And we have our winners!");
        System.out.println(places.get(0) + " took the gold...");
        System.out.println(places.get(1) + " got the silver...");
        System.out.println("and " + places.get(2) + " took home the bronze.");
    }
}

public class CDLApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Prepping...");

        Race r = new Race(
                "Beverly Takes a Bath",
                "RockerHorse",
                "Phineas",
                "Ferb",
                "Tin Cup",
                "I'm Faster Than a Monkey",
                "Glue Factory Reject"
        );

        System.out.println("It's a race of " + r.getDistance() + " lengths");
        System.out.println("Press Enter to run the race...");
        System.in.read();

        r.run();
    }
}
