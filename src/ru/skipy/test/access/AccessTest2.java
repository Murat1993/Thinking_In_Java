package ru.skipy.test.access;

public class AccessTest2 {

    private int privateField = 0;

    public int getPrivateField() {
        return privateField;
    }

    public void testAccss(AccessTest2 anotherObject) {
        anotherObject.privateField = 1;
        System.out.println("anotherObject.getPrivateField() = " + anotherObject.getPrivateField());
        System.out.println("anotherObject.privateField = " + anotherObject.privateField);
    }
}
