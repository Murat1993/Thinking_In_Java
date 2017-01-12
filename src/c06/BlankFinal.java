//: c06:BlankFinal.java
// "Пустые" неизменные поля.
package c06;

class Poppet {
    private int i;

    Poppet(int ii) {
        i = ii;
    }
}

public class BlankFinal {
    private final int i = 0;
    private final int j;
    private final Poppet p;

    // Пустые констант НЕОБХОДИМО инициализировать
    // в конструкторе:
    public BlankFinal() {
        j = 1;  // Инициализация пустой константы
        p = new Poppet(1);  // Инициализация пустой неизменной ссылки
    }

    public BlankFinal(int x) {
        j = x;  // Инициализация пустой константы
        p = new Poppet(x);  // Инициализация пустой неизменной ссылки
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
