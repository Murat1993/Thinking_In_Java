//: typeinfo/SweetShop.java
// Проверка процесса загрузки классов.
package typeinfo;

class Candy {
    static {
        System.out.println("Загрузка класса Candy");
    }
}

class Gum {
    static {
        System.out.println("Загрузка класса Gum");
    }
}

class Cookie {
    static {
        System.out.println("Загрузка класса Cookie");
    }
}


public class SweetShop {
    public static void main(String[] args) {
        System.out.println("в методе main()");
        //new Gum();
        new Candy();
        System.out.println("После создания обьекта Candy");
        try {
            Class.forName("typeinfo.Gum");
            //Class.forName("Candy");
        } catch (ClassNotFoundException e) {
            System.out.println("Класс Gum не найден");
        }
        System.out.println("После вызова метода Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("После создания обьекта Cookie");
    }
}
