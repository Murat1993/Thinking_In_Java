//: exceptions/RethrowNew.jaa
// Повторное возбуждение обьекта,
// отличающегося от первоночального
package exceptions;

class OneException extends Exception {
    public OneException(String s) {
        super(s);
    }
}

class TwoException extends Exception {
    public TwoException(String s) {
        super(s);
    }
}

public class RethrowNew {

    public static void f() throws OneException {
        System.out.println("создание исключения в f()");
        throw new OneException("из f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Во внутреннем блоке try, e.printStackTrace()");
                e.printStackTrace(System.out);
                throw new TwoException("из внутреннего блока try");
            }
        } catch (TwoException e) {
            System.out.println("Во внешнем блоке try, e.printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
