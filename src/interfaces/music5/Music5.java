//: interfaces/music5/Music5.java
// Интерфейсы.
package interfaces.music5;
import polymorphism.music.Note;

interface Instrument {
    // Константа времени компиляции:
    int VALUE = 5; // static & final
    // Определние методов недопустимы:
    void play(Note n); // Автоматически обьявлен как public
}

class Wind implements Instrument {
    public void play(Note n) {
        System.out.println(this + ".play()" + n);
    }
    public String toString() {
        return "Wind";
    }
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Percussion implements Instrument {
    public void play(Note n) {
        System.out.println(this + ".play()" + n);
    }
    public String toString() {
        return "Percussion";
    }
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Stringed implements Instrument {
    public void play(Note n) {
        System.out.println(this + ".play()" + n);
    }
    public String toString() {
        return "Stringed";
    }
    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class Brass extends Wind {
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    public String toString() {
        return "Woodwind";
    }
}

public class Music5 {
    // Работа метода не зависит от фактического типа объекта
    // поэтому типы, добавленные в систему, будут работать правильно:
    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for (Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        // Восходящее преобразование при добавлении в массив:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}
