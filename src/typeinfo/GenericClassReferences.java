//: typeinfo/GenericReferences.java
package typeinfo;


public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // To же самое
        intClass = double.class;
        //genericIntClass = double.class; // Недопустимо
    }
}
