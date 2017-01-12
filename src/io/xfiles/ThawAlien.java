//: io/xfiles/ThawAlien.java
// Попытка восстановления сериализованного файла
// без сохранения класса объекта в зтом файле.
// {RunByHand}
package io.xfiles;


import java.io.*;

public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
