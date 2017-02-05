package concurrency;


public class MainThread {
    public static void main(String[] args) {
//        LiftOff launch = new LiftOff();
//        Thread thread = new Thread(launch);
//        thread.start();

        LiftOff launch = new LiftOff();
        launch.run();
    }
}
