package ru.skipy.tests.io;

import java.io.*;

class B implements Serializable {
    private static int n = 0;
    private int i;

    B(int i) {
        this.i = i;
        n = i;
    }

    @Override
    public String toString() {
        return i + " " + n;
    }

    public static void serializeStatic(ObjectOutputStream oos) throws IOException {
        oos.writeInt(n);
    }
    public static void deserializeStatic(ObjectInputStream ois) throws IOException {
        n = ois.readInt();
    }
}


public class SerializeStatic {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        B b = new B(5);
        System.out.println(b);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialize.dat"));
        B.serializeStatic(oos);

        oos.writeObject(b);
        b = new B(10);
        System.out.println(b);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialize.dat"));
        B.deserializeStatic(ois);
        b = (B) ois.readObject();
        System.out.println(b);
    }
}
