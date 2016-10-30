package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;

public class Solution {
    public static void main(String[] args) {

        String secretKey = "Muratbek19932509";
        String encryptMode = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];

        Key aesKey = new SecretKeySpec(secretKey.getBytes(), "AES");
        Cipher cipher = null;
        try
        {
            cipher = Cipher.getInstance("AES");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        try
        {
            if (encryptMode.equals("-e")) {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
                cipher.init(Cipher.ENCRYPT_MODE, aesKey);
                String string;
                while ((string = reader.readLine()) != null) {
                    byte[] encrypted = cipher.doFinal(string.getBytes());
                    fileOutputStream.write(encrypted);
                }
            }
            else if (encryptMode.equals("-d")) {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

                cipher.init(Cipher.DECRYPT_MODE, aesKey);


                int[] byteArray = new int[fileInputStream.available()];
                int i = 0;
                while (fileInputStream.available() > 0) {
                    byteArray[i] = fileInputStream.read();
                    i++;
                }


                byte[] byteArrayByte = new byte[byteArray.length];
                for (int j = 0; j < byteArray.length; j++) {
                    byteArrayByte[j] = (byte) (byteArray[j] & 255);

                }
                byte[] bytes = cipher.doFinal(byteArrayByte);

                for (byte byteInBytes : bytes) {
                    fileOutputStream.write(byteInBytes);
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

}
