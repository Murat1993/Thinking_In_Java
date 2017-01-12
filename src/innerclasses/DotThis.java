//: innerclasses/DoThis.java
// Обращение к обьекту внешнего класса.
package innerclasses;


public class DotThis {
    private String name = "Major";

    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        private String inner = "inner string";

        public DotThis outer() {
            System.out.println(DotThis.this.name);
            return DotThis.this;
            // A plain "this" would be Inner's "this"
        }

        public void inner() {
            System.out.println(inner);
            Inner inner = DotThis.this.inner();
            inner.outer();
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        Inner dti2 = dt.inner();

        dti.outer().f();
        dti2.outer().f();
        dti2.inner();
    }
}
