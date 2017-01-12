//: innerclasses/Parcel6.java
// Вложение класса в область действия
package innerclasses;


public class Parcel6 {
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }

    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                    System.out.println(s);
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("ожидание");
            String s = ts.getSlip();
        }
        // Здесь использовать класс нельзя!
        // Вне области видимости.
        //! TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() {
        internalTracking(true);
    }
}
