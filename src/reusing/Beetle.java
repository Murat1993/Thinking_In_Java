//: reusing/Beetle.java
// Полный процесс инициализации
package reusing;

class Insect {
    private int i = 9;
    protected int j;
    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }
    private static int x1 = printInit("Поле static Insect.x1 инициализировано");
    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInit("Поле Beetle.k инициализировано");
    public Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }
    private static int x2 = printInit("Поле static Beetle.x2 инициализировано");

    public static void main(String[] args) {
        System.out.println("Конструктор Beetle");
        //Beetle b = new Beetle();
    }
}
