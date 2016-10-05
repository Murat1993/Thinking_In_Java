package concurrency;

import java.util.HashSet;
import java.util.Set;

// package com.javarush.test.level21.lesson05.task01;

/* Equals and HashCode В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании. */

public class Solution {

    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Solution))
            return false;

        Solution other = (Solution)o;

        return this.first.equals(other.first) && this.last.equals(other.last);
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + first.hashCode();
        result = 31 * result + last.hashCode();

        return result;
    }


    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}