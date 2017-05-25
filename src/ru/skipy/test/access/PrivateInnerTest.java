package ru.skipy.test.access;

public class PrivateInnerTest {

    private Inner inner;

    public PrivateInnerTest() {
        inner = new Inner();
    }

    public void test() {
        System.out.println("Field: " + inner.field);
        System.out.println("Method: " + inner.getField());
    }

    private class Inner {
        private int field;

        private Inner() {
            field = 1;
        }

        public int getField() {
            return field;
        }
    }

    public static void main(String[] args) {
        PrivateInnerTest pit = new PrivateInnerTest();
        pit.test();
    }
}
