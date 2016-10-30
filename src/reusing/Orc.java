//: reusing/Orc.java
// Ключевое слово protected
package reusing;


class Villain {
    private String name;
    protected void set(String name) {
        this.name = name;
    }
    public Villain(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Я обьект Villain и мое имя " + name;
    }
}

public class Orc extends Villain {
    private int orcNumber;
    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }
    public void change(String name, int orcNumber) {
        set(name);  // Доступно, так как обьявлено protected
        this.orcNumber = orcNumber;
    }

    @Override
    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Лимбургер", 12);
        System.out.println(orc);
        orc.change("Боб", 19);
        System.out.println(orc);
    }
}
