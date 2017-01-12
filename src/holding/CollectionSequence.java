//: holding/CollectionSequence.java
package holding;


import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection {

    private Pet[] pets = Pets.createArray(8);

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // Не реализован
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }

    @Override
    public int size() {
        return pets.length;
    }
}
