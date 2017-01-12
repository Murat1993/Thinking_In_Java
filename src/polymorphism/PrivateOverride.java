//: polymorphism/PrivateOverride.java
// Попытка переопределения приватного метода
package polymorphism;


public class PrivateOverride {
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        Derived derived = new Derived();
        po.f();
        derived.f();
    }

}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()");
    }
}
