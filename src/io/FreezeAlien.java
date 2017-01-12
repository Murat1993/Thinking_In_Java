//: io/FreezeAlien.java
// Создание файла с данными сериализации.
package io;


import java.io.*;

public class FreezeAlien {
    public static void main(String[] args) throws IOException {
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien quellek = new Alien();
        output.writeObject(quellek);
    }
}
