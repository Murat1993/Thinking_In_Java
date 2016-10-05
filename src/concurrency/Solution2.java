package concurrency;

/* Тренировка мозга
Найти логическую ошибку: метод doAction в реализации интерфейса Movable должен выдавать "moving".
Исправьте ошибку, при необходимости измените (отрефакторите) интерфейс Movable.
Результат вывода в консоль должен быть:
flying
moving
*/
public class Solution2 {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Util.fly(duck);
        Util.move(duck);
    }
    public static class Duck implements Flyable, Movable {
        @Override
        public void doAction(String x) {
            System.out.println(x);
        }
    }

    public static class Util {
        static void fly(Flyable animal) {
            String x = "flying";
            animal.doAction(x);
        }
        static void move(Movable animal) {
            String y = "moving";
            animal.doAction(y);
        }
    }


    public static interface Flyable {
        void doAction(String x);
    }


    public static interface Movable {
        void doAction(String y);
    }
}
