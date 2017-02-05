//: innerclasses/DotNew.java
// Непосредственное создание внутреннего класса в синтаксисе .new
package innerclasses;


public class DotNew {
    private String anotherString;

    public class Inner {
        private String id;

        public Inner(String id) {
            this.id  = id;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner("first");
        System.out.println(dni);

        Inner newInner = dn.new Inner("second");
        System.out.println(newInner);
    }
}
