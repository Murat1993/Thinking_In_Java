//: generics/SimplerPets.java
package net.mindview.util;

import blogpost.javarevisited.Person;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        // Rest of the code is same...
    }
}
