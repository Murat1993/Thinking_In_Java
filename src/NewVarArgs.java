//: initialization/NewVarArgs.java
// Создание списков аргументов переменной длины
// с использованием синтаксиса массивов.

import java.util.Objects;

public class NewVarArgs {
    static void printArray(Object... args) {
        for (Object obj :args) {
            System.out.println(obj + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Можно передать отдельные элементы:
        printArray(new Integer(47), new Float(3.14), new Double(11.11));
        printArray(47, 3.14F, 11.11);
        printArray(new A(), new A(), new A());
        // Или массив:
        printArray((Object[])new Integer[]{1, 2, 3, 4});
        printArray(); // Пустой список тоже возможен
    }
}
