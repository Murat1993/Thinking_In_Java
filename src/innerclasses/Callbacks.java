//: innerclasses/Callbacks.java
// Использование внутренних классов
// для реализации обратных вызовов
package innerclasses;

interface Incrementable {
    void increment();
}

// Простая реализация интерфейса:
class Callee1 implements Incrementable {

    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {

    public static void f(MyIncrement mi) {
        mi.increment();
    }

    public void increment() {
        System.out.println("Другая операция");
    }
}


// Если класс должен вызывать метод increment()
// по-другому, необходимо использовать внутренний класс:
class Callee2 extends MyIncrement {
    private int i = 0;

    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }

    private class Closure implements Incrementable {

        @Override
        public void increment() {
            // Указывается метод внешнего класса:
            // в противном случае возникает бесконечная рекурсия.
            Callee2.this.increment();
        }
    }
}

class Caller {
    private Incrementable callbackReference;

    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }

    void go() {
        callbackReference.increment();
    }
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();

        MyIncrement.f(c2);

        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());


        caller1.go();
        caller1.go();

        caller2.go();
        caller2.go();


    }
}
