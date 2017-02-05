//: interfaces/music4/Music4.java
// Абстрактные классы и методы
package interfaces;

import polymorphism.music.Note;

abstract class Instrument {
    private int i; // Память выделяется для каждого обьекта

    public abstract void play(Note n);

    public String what() {
        return "Instrument";
    }

    public abstract void adjust();
}

class Wind extends Instrument {
    public void play(Note n) {
        System.out.println("Wind play() " + n);
    }

    public String what() {
        return "Wind";
    }

    public void adjust() {
    }
}

class Percussion extends Instrument {
    public void play(Note n) {
        System.out.println("Percussion play() " + n);
    }

    public String what() {
        return "Percussion";
    }

    public void adjust() {
    }
}

class Stringed extends Instrument {
    public void play(Note n) {
        System.out.println("Stringed play() " + n);
    }

    public String what() {
        return "Stringed";
    }

    public void adjust() {
    }
}

class Brass extends Wind {
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    public void adjust() {
        System.out.println("Brass adjust()");
    }
}

class Woodwind extends Wind {
    public void play(Note n) {
        System.out.println("Woodwind play() " + n);
    }

    public String what() {
        return "Woodwind";
    }
}

public class Music4 {
    // Работа метода не зависит от фактического типа обьекта,
    // поэтому типы, добавленные в систему, будут работать правильно:
    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        // Восходящее преобразование при добавлении в массив
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
