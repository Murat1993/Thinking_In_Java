package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            List<String> listOfParts = new ArrayList<>();
            List<String> listOfFullFileName = new ArrayList<>();
            String fileName;
            while (!(fileName = reader.readLine()).equals("end"))
            {
                listOfFullFileName.add(fileName);
                String onlyPart = fileName.split("\\.")[fileName.split("\\.").length-1].toLowerCase();
                listOfParts.add(onlyPart);
            }
            reader.close();




            List<Integer> numberOfParts = new ArrayList<>();

            String number = "";

            for (String string : listOfParts) {
                char[] chars = string.toCharArray();
                for (char character : chars) {
                    if (Character.isDigit(character)) {
                        number += character;
                    }
                }
                numberOfParts.add(Integer.parseInt(number));
                number = "";
            }

            Collections.sort(numberOfParts);


            String[] splitedFileName = listOfFullFileName.get(0).split("\\.");
            String finalFileName = "";
            for (int i = 0; i < splitedFileName.length - 1; i++) {
                if (i == splitedFileName.length -2) {
                    finalFileName += splitedFileName[i];
                } else
                {
                    finalFileName += splitedFileName[i] + ".";
                }
            }

            FileOutputStream finalOutputFile = new FileOutputStream(finalFileName);
            for (Integer integer : numberOfParts) {
                for (String fileNames : listOfFullFileName) {
                    if (fileNames.split("\\.")[fileNames.split("\\.").length - 1].contains(Integer.toString(integer)))
                    {
                        finalOutputFile = new FileOutputStream(finalFileName, true);
                        FileInputStream fileInputStream = new FileInputStream(fileNames.toLowerCase());
                        while (fileInputStream.available() > 0)
                        {
                            finalOutputFile.write(fileInputStream.read());
                        }
                        fileInputStream.close();
                    }
                }
            }
            finalOutputFile.close();


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
