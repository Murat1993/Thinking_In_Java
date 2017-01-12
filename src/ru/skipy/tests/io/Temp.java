package ru.skipy.tests.io;

import java.io.*;

class A implements Serializable {
    private static int n = 0;
    private int i;

    A(int i) {
        this.i = i;
        n = i;
    }

    @Override
    public String toString() {
        return i + " " + n;
    }
}

public class Temp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a = new A(5);
        System.out.println(a);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial.dat"));
        oos.writeObject(a);


        a = new A(10);
        System.out.println(a);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial.dat"));
        a = (A) ois.readObject();
        System.out.println(a);
    }
}
