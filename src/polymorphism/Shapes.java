//: polymorphism/Shapes.java
// Polymorphism in Java.
package polymorphism;

import polymorphism.shape.RandomShapeGenerator;
import polymorphism.shape.Shape;


public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        // Заполняем массив фигурами:
        for (int i = 0; i < s.length; i++)
            s[i] = gen.next();
        // Полиморфные вызовы методов:
        for (Shape shp : s) {
            shp.draw();
        }
    }
}
