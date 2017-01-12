//: holding/ListFeatures.java
package holding;

import typeinfo.pets.*;

import java.util.*;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        System.out.println("1: " + pets);

        Hamster h = new Hamster();
        pets.add(h); // Автоматическое изменение размера

        System.out.println("2: " + pets);

        System.out.println("3: " + pets.contains(h));
        pets.remove(h); // Удаление обьекта
        Pet p = pets.get(2);

        System.out.println("4: " + p + " " + pets.indexOf(p));
        Pet cymric = new Cymric();

        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.remove(cymric));

        // Точно заданный обьект:
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);

        pets.add(3, new Mouse()); // Вставка по индексу
        System.out.println("9: " + pets);

        List<Pet> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + pets.containsAll(sub));

        Collections.sort(sub); // Сортировка "на месте"
        System.out.println("sorted subList: " + sub);

        // Для containsAll() порядок неважен:
        System.out.println("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, rand);  // Случайная перестановка

        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + pets.containsAll(sub));

        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(pets); // Получение новой копии
        copy.remove(2); // Удаление по индексу
        System.out.println("14: " + copy);
        copy.retainAll(sub); // Удаление всех заданных элементов

        System.out.println("15: " + copy);
        copy.set(1, new Mouse()); // Замена элемента
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // Вставка в середину списка
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());
        pets.clear(); // Удаление всех элеметов
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
        pets.addAll(Pets.arrayList(4));

        System.out.println("21: " + pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);

        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23: " + pa[3].id());
    }
}
