//: io/Blip3.java
// Восстановление объекта Externalizable.
package io;


import java.io.*;

public class Blip3 implements Externalizable {

    private int i;
    private String s; // No initialization
    public Blip3() {
        System.out.println("Blip3 Constructor");
        // s, i not initialized
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
        // s & i initialized only in non-default constructor.
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        // You mus do this;
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        // You mus do this:
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip3 blip3 = new Blip3("A String, ", 47);
        System.out.println(blip3);

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving object:");
        o.writeObject(blip3);
        o.close();


        // Not get it back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering b3:");
        blip3 = (Blip3) in.readObject();
        System.out.println(blip3);


    }
}
