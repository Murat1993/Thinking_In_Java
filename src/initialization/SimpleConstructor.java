package initialization;

//: initialization/SimpleConstructor.java
// Demonstration of a simple constructor.
// Демонстрация простого конструктора

class Rock {
    Rock() {
        System.out.print("Rock ");
    }
}

public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock();
        }
    }
}
