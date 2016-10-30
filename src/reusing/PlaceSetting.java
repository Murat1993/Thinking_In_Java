//: reusing/PlaceSetting.java
// Совмещение композоции и наследования.
package reusing;

class Plate {
    Plate(int i) {
        System.out.println("Конструктор Plate");
    }
}

class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        System.out.println("Конструктор DinnerPlate");
    }
}

class Utensil {
    Utensil(int i) {
        System.out.println("Конструктор Utensil");
    }
}

class Spoon extends Utensil {
    Spoon(int i) {
        super(i);
        System.out.println("Конструктор Spoon");
    }
}


class Fork extends Utensil {
    Fork(int i) {
        super(i);
        System.out.println("Конструктор Fork");
    }
}

class Knife extends Utensil {
    Knife(int i) {
        super(i);
        System.out.println("Конструктор Knife");
    }
}

class Custom {
    Custom(int i) {
        System.out.println("Конструктор Custom");
    }
}

public class PlaceSetting extends Custom {
    private Spoon sp;
    private Fork fork;
    private Knife knife;
    private DinnerPlate dinnerPlate;
    public PlaceSetting(int i) {
        super(i + 1);
        sp = new Spoon(i + 2);
        fork = new Fork(i + 3);
        knife = new Knife(i + 4);
        dinnerPlate = new DinnerPlate(i + 5);
        System.out.println("Конструктор PlaceSetting");
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
}
