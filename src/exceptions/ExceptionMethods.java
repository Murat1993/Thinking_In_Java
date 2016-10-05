//: exceptions/ExceptionsMethods.java
// Демонстрация методов класса Exception.
package exceptions;


public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("Мое исклюение");
        } catch (Exception e) {
            System.out.println("Перехвачено");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
