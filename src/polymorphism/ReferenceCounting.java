//: polymorphism/ReferenceCounting.java
// Унитожение совместно используемых встроенных обьектов
package polymorphism;


class Shared {
    private static long counter = 0;
    private final long id = counter++;
    private int refcount = 0;

    public Shared() {
        System.out.println("Создаем " + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0)
            System.out.println("Disposing " + this);
    }

    @Override
    public String toString() {
        return "Disposing " + id;
    }
}


class Composing {
    private static long counter = 0;
    private final long id = counter++;
    private Shared shared;

    public Composing(Shared shared) {
        System.out.println("Создаем " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)
        };

        for (Composing c : composing) {
            c.dispose();
        }
    }
}
