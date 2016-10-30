// reusing/SprinklerSystem.java
// Композиция для повторного использования кода.
package reusing;

class WaterSource {
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "сконструирован";
    }

    public String toString() {
        return s;
    }
}

public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return
                "valve1 = " + valve1 + " " +
                "valve2 = " + valve2 + " " +
                "valve3 = " + valve3 + " " +
                "valve4 = " + valve4 + "\n" +
                "i = " + i + " " + "f = " + f + " " +
                "source = " + source;
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklesrs = new SprinklerSystem();
        System.out.println(sprinklesrs);
    }
}
