package concurrency;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Comp2 implements Comparator<String> {

    @Override
    public int compare(String obj1, String obj2) {
        // поиск пробелов, для сортировки по фамилии
        int k = obj1.substring(obj1.indexOf(" "))
                .compareTo(obj2.substring(obj2.indexOf(" ")));
        if (k == 0) {
            return obj1.compareTo(obj2);
        } else {
            return k;
        }
    }
}

public class ComparatorExapmle {
    public static void main(String[] args) {
        TreeSet<String> ex = new TreeSet<>(new Comp2());
        ex.add("Stive Global");
        ex.add("Stive Cooper");
        ex.add("Nancy Summer");
        ex.add("Aaron Eagle");
        ex.add("Barbara Smith");

        Iterator<String> i = ex.iterator();

        while (i.hasNext()) {
            String ts = i.next();
            System.out.println("Str: " + ts);
        }
    }
}
