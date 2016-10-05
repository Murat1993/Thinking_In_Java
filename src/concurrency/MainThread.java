package concurrency;


public class MainThread {
    public static void main(String[] args) {
        LiftOff launch2 = new LiftOff();
        Thread thread = new Thread(launch2);
        thread.start();
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
