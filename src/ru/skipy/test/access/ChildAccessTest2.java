package ru.skipy.test.access;


public class ChildAccessTest2 extends AccessTest {

    public void testAccess(ChildAccessTest2 anotherObject) { // change to Access Test
        anotherObject.protectedField = 3;
        System.out.println("anotherObject.getProtectedField() = " + anotherObject.getProtectedField());
        System.out.println("anotherObject.protectedFiled = " + anotherObject.protectedField);
    }
}