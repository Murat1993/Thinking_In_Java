package blogpost.javarevisited;

public class Test implements Cloneable {
    int a = 10;
    StringBuffer b = new StringBuffer("abc");

    public static void main(String[] args) {
        Test b1 = new Test();
        try {
            Test b2 = (Test)b1.clone();
            System.out.println("Before");
            System.out.println("b1.a = " + b1.a + " b1.b = " + b1.b);
            System.out.println("b2.a = " + b2.a + " b2.b = " + b2.b);

            b1.a = 20;
            b1.b.append("def");

            System.out.println("After");
            System.out.println("b1.a = " + b1.a + "b1.b = " + b1.b);
            System.out.println("b2.a = " + b2.a + "b2.b = " + b2.b);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
