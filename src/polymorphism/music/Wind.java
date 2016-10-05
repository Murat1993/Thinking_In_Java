//: polymorphism/music/Wind.java
package polymorphism.music;


// Обьекты Wind также являются обьектами Instrument.
// Поскольку имеют тот же интерфейс:

public class Wind extends Instrument {
    // Переопределение метода интерфейса
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}
