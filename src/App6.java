/**
 * Created by murat on 12.05.16.
 */
public class App6 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {
                throw new RuntimeException();
            }
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
}
