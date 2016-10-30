//: generics/coffee/CoffeeGenerator.java
// Генератор случайных обьектов из иерархии Coffee
package generics.coffee;


import net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = { Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class, };
    private static Random random = new Random(47);

    public CoffeeGenerator() {
    }
    // Для перебора
    private int size = 0;
    public CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
            // Сообщение об ощибках во время выполнения:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }


        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        for (Coffee c : new CoffeeGenerator(5)) {
            System.out.println(c);
        }
    }
}
