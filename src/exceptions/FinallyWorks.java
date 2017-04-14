//: exceptions/FinallyWorks.java
// Блок finally выполняется всегда
package exceptions;

class ThreeException extends Exception {

}

public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                // Post-increment is zero first time:
                if (count++ == 0)
                    throw new ThreeException();
                System.out.println("No exception");
            } catch (ThreeException e) {
                e.printStackTrace();
            } finally {
                System.out.println("In finally clause");
                System.out.println(count);
                if (count == 3) // out fo "while"
                    break;
            }
        }
    }
}
