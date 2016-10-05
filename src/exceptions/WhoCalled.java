//: exceptions/WhoCalled.java
// Программный доступ к данным трассировки стека
package exceptions;


public class WhoCalled {
    static void f() {
        // Выдача исключения для заполнения трассировочных данных
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println("ste.getMethodName: " + ste.getMethodName());
                //System.out.println("ste.getLineNumber: " + ste.getLineNumber());
            }
        }
    }
    static void g() {
        f();
    }
    static void h() {
        g();
    }
    public static void main(String[] args) {
        f();
        System.out.println("---------------------------------");
        g();
        System.out.println("---------------------------------");
        h();
    }
}
