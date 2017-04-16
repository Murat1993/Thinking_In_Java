//: exceptions/MainException.java
package exceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class MainException {
    // Передаем все исключения на консоль:
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("src/exceptions/MainException.java");
        // Используем файл ...
        // Закрываем файл:
        while (file.available() > 0) {
            System.out.println(file.read());
        }
        file.close();
    }
}
