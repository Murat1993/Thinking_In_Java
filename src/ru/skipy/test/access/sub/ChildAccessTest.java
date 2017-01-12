package ru.skipy.test.access.sub;


import ru.skipy.test.access.AccessTest;

public class ChildAccessTest extends AccessTest {

    public void testAccess(ChildAccessTest anotherObject) {
        anotherObject.protectedField = 3;
        System.out.println("anotherObject.getProtectedField() = " + anotherObject.getProtectedField());
        System.out.println("anotherObject.protectedFiled = " + anotherObject.protectedField);
    }
}
