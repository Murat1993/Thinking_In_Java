//: reusing/Cartoon.java
// Вызовы конструкторов при проведении наследования.
package reusing;

class Art {
    Art() {
        System.out.println("Коструктор Art");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Коструктор Drawing");
    }
}

public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Коструктор Cartoon");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
