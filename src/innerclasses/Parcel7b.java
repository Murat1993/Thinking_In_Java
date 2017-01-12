//: innerclasses/Parcel7b.java
// Расширенная версия Parcel7.java
package innerclasses;


public class Parcel7b {
    public static void main(String[] args) {
        Parcel7b p = new Parcel7b();
        Contents c = p.contents();
        System.out.println(c.value());
    }

    public Contents contents() {
        return new MyContents();
    }

    class MyContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }
}
