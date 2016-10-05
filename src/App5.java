
public class App5 {
    public static void main(String[] args) {
        try {
            // throw new RuntimeException();
            // return;
            // System.exit(42);
            // Runtime.getRuntime().exit(42);
            Runtime.getRuntime().halt(42);
        } finally {
            System.err.println("finally");
        }
    }
}
