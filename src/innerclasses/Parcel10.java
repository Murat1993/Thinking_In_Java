//: innerclasses/Parcel10.java
// Демонстрация "инициализации экземпляра" для
// конструирования безымянного внутреннего класса.
package innerclasses;


public class Parcel10 {
    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Тасмания", 101_395F);
    }

    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            private String label = dest;

            // Инициализация экземпляра для каждого обьекта.
            {
                cost = Math.round(price);
                if (cost > 100)
                    System.out.println("Превышение бюджета!");
            }

            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}
