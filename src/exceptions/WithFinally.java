//: exceptions/WithFinally.java
// Finally гарантирует выполнение завершающего кода.
package exceptions;

public class WithFinally {
    static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            OnOffSwitch.f();
        } catch (OnOffException1 onOffException1) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 onOffException2) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
}
