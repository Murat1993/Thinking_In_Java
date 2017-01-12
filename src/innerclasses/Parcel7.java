//: innerclasses/Parcle7.java
// Метод возвращает экземпляр безымянного внутреннего класса
package innerclasses;

public class Parcel7 {
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c.value());
    }

    public Contents contents() {
        return new Contents() {
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }
}
