//: typeinfo/toys/ToyTest.java
// Тестирование класса Class.
package typeinfo.toys;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    // Закоментируйте следущий далее конструктор по
    // умолчанию, тогда в строке с пометкой (*1*)
    // возникнет ошибка NoSuchMethodError.

    Toy() {
    }

    Toy(int i) {
    }

}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Имя класса: " + cc.getName() +
                " это интерфейс? [" + cc.isInterface() + "]");
        System.out.println("Простое имя: " + cc.getSimpleName());
        System.out.println("Каноническое имя: " + cc.getCanonicalName());
        System.out.println();
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс FancyToy");
            System.exit(1);
        }

        printInfo(c);

        for (Class face : c.getInterfaces())
            printInfo(face);

        Class up = c.getSuperclass();
        Object object = null;
        try {
            // Необходим конструктор по умолчанию
            object = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Не удалось создать обьект");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Нет доступа");
            System.exit(1);
        }

        printInfo(object.getClass());
    }
}
