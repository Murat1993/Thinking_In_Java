//: reusing/FinalOverridingIllusion.java
// Все выглядет так, будто закрытый (и неизменный) метод
// можно переопределить, но это заблуждение.
package reusing;

class WithFinals {
    // То же, что и просто private:
    private final void f() {
        System.out.println("WithFinals f()");
    }

    // Так же автоматически является final
    private void g() {
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        System.out.println("OverridingPrivate f()");
    }

    private void g() {
        System.out.println("OverridingPrivate g()");
    }
}


class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        System.out.println("OverridingPrivate2 f()");
    }

    public void g() {
        System.out.println("OverridingPrivate2 g()");
    }
}

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // Можно провести восходящее преобразование:
        OverridingPrivate op = op2;
        // Но методы при этом вызвать невозможно:
        //! op.f();
        //! op.g();
        // И то же самое здесь:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();
    }
}
