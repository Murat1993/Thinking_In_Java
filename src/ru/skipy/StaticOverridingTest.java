package ru.skipy;

public class StaticOverridingTest {

    public static class Parent {
        public void test() {
            System.out.println("parent::test");
        }

        public static void staticCall() {
            System.out.println("static call parent");
        }
    }

    public static class Child extends Parent {
        public void test() {
            System.out.println("child::test");
        }

        public static void staticCall() {
            System.out.println("static call child");
        }
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        p.staticCall();
        p.test();

        System.out.println();

        Child c = new Child();
        c.staticCall();
        c.test();
    }
}
