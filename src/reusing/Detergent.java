//: reusing/Detergent.java
// Синтаксис наследования и его свойства
package reusing;


class Cleanser {
    private String s = "Cleanser";

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Detergent extends Cleanser {
    // Проверяем новый класс.
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Проверяем базовый класс");
        Cleanser.main(args);
    }

    // Изменяем метод
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Вызываем метод базавого класса
    }

    public void dilute() {
        append(" Detergent.dilute()");
        super.apply();
    }

    // Добавляем новые методы к интерфейсу
    public void foam() {
        append(" foam()");
    }
}
