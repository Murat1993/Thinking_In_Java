//: interfaces/classprocessor/Apply.java
package interfaces.classprocessor;

import java.util.Arrays;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    String process(Object input) { // Ковариантный возвращаемый тип
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(Object input) {
        // Аргумент split() используется для разбиения строки
        return Arrays.toString(((String) input).split(" "));
    }
}

public class Apply {
    public static String s = "Disagreement with belief is by definition incorrect";

    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
        System.out.println('\u2122');
        System.out.println('\u03C0');
    }
}
