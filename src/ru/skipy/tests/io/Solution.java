package ru.skipy.tests.io;

import java.io.Serializable;

/* Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
*/
public class Solution {

    // first variant: not available
    public class A {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        public A() {

        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }

        public B() {

        }


    }

    public class C extends B implements Serializable {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }
}

