//: innerclasses/controller/Controller.java
// Обобщенная система управления
package innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    // Класс из пакета java.util для хранения событий Event::
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            for (Event e : new ArrayList<>(eventList))
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
        }
    }

}
