//: reusing/FinalArgument.java
// Использование final с аргументами метода
package reusing;

class Gizmo {
    public void spin() {}
}

public class FinalArguments {
    void with(final Gizmo g) {
        //! g = new Gizmo(); // запрещено -- g обьявлено final
        g.spin();
    }
    void without(Gizmo g) {
        g = new Gizmo(); // Разрешено -- g не являеться final
        g.spin();
    }

    // void f(final int i) { i++; } // Нельзя изменять.
    // неизменные примитивы доступны только для чтения;
    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(new Gizmo());
        bf.with(new Gizmo());
    }
}