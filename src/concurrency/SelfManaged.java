package concurrency;


public class SelfManaged implements Runnable {

    private int countDown = 5;

    public SelfManaged() {
        Thread t = new Thread(this);
        t.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }

    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }
}
