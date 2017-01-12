package ru.skipy;

public class LinkageTest {

    public static class Parent {

        public void test() {
            System.out.println("parent::test");
        }

    }

    public static class Child extends Parent {

        public void test() {

        }
    }

}
