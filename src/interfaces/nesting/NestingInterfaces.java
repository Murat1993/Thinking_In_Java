//: interfaces/nesting/NestingInterfaces.java
package interfaces.nesting;

class A {
    interface B {
        void f();
    }

    public class BImp implements B {
        public void f() {}
    }

    private class BImp2 implements B {

        @Override
        public void f() {

        }
    }

    public interface C {
        void f();
    }

    class CImp implements C {

        @Override
        public void f() {

        }
    }
}

public class NestingInterfaces {

}
