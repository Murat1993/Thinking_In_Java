//: innerclasses/MultiNestingAccess.java
// Вложенные классы могут обращаться ко всем членам всех
// классов, в которых они находятся.
package innerclasses;

class MNA {
    private void f() {
        System.out.println("f()");
    }

    private void g() {
        System.out.println("g() in MNA");
    }

    class A {
        private void g() {
            System.out.println("g() in A");
        }

        public class B {

            private void g() {
                System.out.println("g() in B");
            }

            void h() {
                g();
                A.this.g();
                MNA.this.g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
