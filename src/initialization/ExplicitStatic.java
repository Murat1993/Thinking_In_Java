//: initialization/ExplicitStatic.java
// Явная инициализация с использованием конструкции "static"
package initialization;

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }
    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static Cup cup3;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
        cup3 = new Cup(3);
    }

    Cups() {
        System.out.println("Cups()");
    }
}

public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup3.f(99); // (1)
    }
}
