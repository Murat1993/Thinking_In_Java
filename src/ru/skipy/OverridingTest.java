package ru.skipy;

public class OverridingTest {

    public static class Parent {
        public Parent() {
            test();
        }

        public void test() {
            System.out.println("parent::test");
        }
    }

    public static class Child extends Parent {

        private String field;

        public Child() {
            field = "abc";
        }

        public void test() {
            System.out.println("child::test");
            System.out.println("filed = " + field);
        }
    }

    public static void main(String[] args) {
        new Child();
    }
}
