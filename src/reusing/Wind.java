//: reusing/Wind.java
// Наследование и восходящее преобразование.
package reusing;

class Instrument {
    public void play() {}

    static void tune(Instrument i) {
        // ...
        i.play();
    }
}


// Обьекты Wind также являются обьектами Instrument,
// поскольку они имеют тот же интерфейс:
public class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Восходящее преобразование
    }
}
