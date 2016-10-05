
public class Flower {
    int petalCout = 0;
    String s = "initial value";
    Flower(int petals) {
        petalCout = petals;
        System.out.println("Contstructor w/ int args only, petalCount= " + petalCout);
    }
    Flower(String ss) {
        System.out.println("Constructor w/ String arg only, s = " +  ss);
        s = ss;
    }
    Flower(String s, int petals) {
        this(petals);
        //! this(s); // Can't call two!
        this.s = s;  // Another use of "this"
        System.out.println("String & int args");
    }
    Flower() {
        this("hi", 47);
        System.out.println("default constructor (no args)");
    }
    void printPetalCount() {
        //! this(11); // Not inside non-constructor!
        System.out.println("petalCount = " + petalCout + " s = " + s);
    }
    public static void  main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
