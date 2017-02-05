//: reusing/CADSystem.java
// Обеспечение необходимого завершения
package reusing;

class Shape {
    Shape(int i) {
        System.out.println("Конструктор Shape");
    }

    void dispose() {
        System.out.println("Завершение Shape");
    }
}

class Circle extends Shape {
    Circle(int i) {
        super(i);
        System.out.println("Рисуем окружность Circle");
    }

    void dispose() {
        System.out.println("Стираем окружность Circle");
        super.dispose();
    }
}

class Triangle extends Shape {
    Triangle(int i) {
        super(i);
        System.out.println("Рисуем треугольник Triangle");
    }

    void dispose() {
        System.out.println("Стираем треугольник Triangle");
        super.dispose();
    }
}

class Line extends Shape {
    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        System.out.println("Рисуем линию Line: " + start + ", " + end);
    }

    void dispose() {
        System.out.println("Стираем линию Line: " + start + ", " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];

    public CADSystem(int i) {
        super(i + 1);
        for (int j = 0; j < lines.length; j++) {
            lines[j] = new Line(j, j * j);
        }
        c = new Circle(1);
        t = new Triangle(1);
        System.out.println("Комбинированный конструктор");
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        try {
            // Код и обработка исключений.
        } finally {
            x.dispose();
        }
    }

    void dispose() {
        System.out.println("CADSystem.dispose()");
        // Завершение осуществляется в порядке,
        // обратном порядку инициализации
        t.dispose();
        c.dispose();
        for (int i = lines.length - 1; i >= 0; i--) {
            lines[i].dispose();
        }
        super.dispose();
    }

}
