//: holding/EnvironmentVariables.java
package generics.coffee;


import java.util.Map;

public class EnvironmentVariables {
    public static void main(String[] args) {
        for(Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
