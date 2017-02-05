//: innerclasses/Sequence.java
// Хранение последовательности обьектов
package innerclasses;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    private Object[] objects;
    private int next = 0;

    public Sequence(int size) {
        objects = new Object[size];
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);

        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));

        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }

    public void add(Object x) {
        if (next < objects.length)
            objects[next++] = x;
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == objects.length;
        }

        @Override
        public Object current() {
            return objects[i];
        }

        @Override
        public void next() {
            if (i < objects.length)
                i++;
        }
    }
}
