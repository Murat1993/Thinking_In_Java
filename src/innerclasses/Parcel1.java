//: innerclasses/Parcel1
// Создание внутренних классов.
package innerclasses;


public class Parcel1 {

    private static class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    static class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    // Использование внутренних классов имеет много общего
    // с использованием любых других классов в пределах Parcel1:
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Тасмания");

        Contents c = new Contents();
        System.out.println(c.value());

        Destination d = new Destination("To Java Guru");
        System.out.println(d.readLabel());
    }
}
