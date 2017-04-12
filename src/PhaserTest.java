import java.util.concurrent.Phaser;

class MyThread implements Runnable {

    private String string;
    private Phaser phaser;

    MyThread(String string, Phaser phaser) {
        this.string = string;
        this.phaser = phaser;
        this.phaser.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        String tmp;
        System.out.println("Создание переменной");
        phaser.arriveAndAwaitAdvance();

        tmp = string;
        System.out.println("Присваивание переменной значения");
        phaser.arriveAndAwaitAdvance();

        System.out.println("tmp = " + tmp);
        
        phaser.arriveAndDeregister();
    }
}

public class PhaserTest {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        new MyThread("A", phaser);
        new MyThread("B", phaser);
        new MyThread("C", phaser);


        int num = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Конец фазы#" + num);

        num = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Конец фазы#" + num);

        num = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Конец фазы#" + num);

        phaser.arriveAndDeregister();
    }
}
