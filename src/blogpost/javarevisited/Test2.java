package blogpost.javarevisited;

public class Test2 implements Cloneable {

    int a = 10;
    StringBuffer b = new StringBuffer("abc");

    protected Object clone() throws CloneNotSupportedException {
        return new Test2();
    }

    public static void main(String[] args) {
        Test2 b1 = new Test2();
        try {
            Test2 b2 = (Test2) b1.clone();

            System.out.println("Before");
            System.out.println("b1.a = " + b1.a + " b1.b = " + b1.b);
            System.out.println("b2.a = " + b2.a + " b2.b = " + b2.b);

            b1.a = 20;
            b1.b.append("def");

            System.out.println("After");
            System.out.println("b1.a = " + b1.a + " b1.b = " + b1.b);
            System.out.println("b2.a = " + b2.a + " b2.b = " + b2.b);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
