//: interfaces/interfaceprocessor/FilterProcessor.java
package interfaces.interfaceprocessor;

import interfaces.filters.*;

public class FilterProcessor implements Processor {

    Filter filter;

    public void FilterAdapter(Filter filter) {
        this.filter = filter;
    }
    public String name() {
        return null;
    }

    @Override
    public Object process(Object input) {
        return null;
    }
}
