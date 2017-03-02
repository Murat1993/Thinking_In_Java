//: net/mindview/util/FiveTuple.java
package generics;


public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {
    private E fifth;

    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + four + ", " + fifth;
    }
}
