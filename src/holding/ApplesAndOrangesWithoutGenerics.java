//: holding/ApplesAndOrangesWithoutGenerics.java
// Простой пример работы с контейнером
// (компилятор выдает предупреждение).
// {ThrowsException}
package holding;

import java.util.ArrayList;

class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {
}

public class ApplesAndOrangesWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        // Не препятствует добавления обьекта Orange:
        apples.add(new Orange());
        for (Object apple : apples)
            ((Apple) apple).id();
        // Обьект Orange обнаруживается только во время выполнения
    }
}
