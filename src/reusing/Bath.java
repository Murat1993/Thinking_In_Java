//: reusing/Bath.java
// Инициализация в конструкторе с композицией.
package reusing;

class Soap {
    private String s;

    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Bath {
    private String // Инициализвция в точке определения
            s1 = "Счастливый",
            s2 = "Счастливый",
            s3, s4;
    private Soap castille;
    private int i;
    private float toy;

    // Инициализация экземпляра
    {
        i = 47;
    }

    public Bath() {
        System.out.println("В кострукторе Bath()");
        s3 = "Радостный";
        toy = 3.14f;
        castille = new Soap();
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }

    @Override
    public String toString() {
        if (s4 == null) // Отложенная инициализация
            s4 = "Радостный";

        return
                "s1 = " + s1 + "\n" +
                        "s2 = " + s2 + "\n" +
                        "s3 = " + s3 + "\n" +
                        "s4 = " + s4 + "\n" +
                        "i = " + i + "\n" +
                        "toy = " + toy + "\n" +
                        "castille = " + castille;
    }
}

