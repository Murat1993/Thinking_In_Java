//: innerclasses/Parcel5.java
// Вложение класса в тело метода.
package innerclasses;


public class Parcel5 {

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.dest("Тасмания");
        System.out.println(d.readLabel());
    }

    public Destination dest(String s) {

        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(s);
    }
}
