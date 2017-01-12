package ru.nsu.ccfit;

public class PassReferences {
    static void f(PassReferences h) {
        System.out.println("h внутри ");
    }
}
