//: interfaces/InterfaceCollision.java
package interfaces;

interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {

    @Override
    public void f() {

    }

    @Override
    public int f(int i) {       // перегружен
        return 1;
    }
}


class C3 extends C implements I2 {

    @Override
    public int f(int i) {       // перегружен
        return 1;
    }
}


class C4 extends C implements I3 {
    // Идентичны, все нормально:
    public int f() {
        return 1;
    }
}

// Методы различаются только по типу возвращаемого значения:
//! class C5 extends C implements I1 {}
//! interface I4 extends I1, I3 {}

public class InterfaceCollision {
}
