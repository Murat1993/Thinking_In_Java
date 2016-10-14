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
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rawFileName;
        String destinationFileName;
        Map<String, String> filesMap = new TreeMap<>();
        try {

            while (!(rawFileName = reader.readLine()).equals("end")) {
                if (!rawFileName.equals("end")) {

                }
                filesMap.put(rawFileName.toLowerCase(), rawFileName);
            }
            reader.close();


            for (Map.Entry<String, String>  file : filesMap.entrySet()){
                String rawName = file.getValue();
                String key = file.getKey();
            }


            /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(finalFileName));

            for (Integer integer : numberOfParts) {
                for (String fuleFileName : listOfFullFileName) {
                    String numberPart = fuleFileName.split("\\.")[fuleFileName.split("\\.").length -1];
                    if (numberPart.contains(""+integer)) {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(fuleFileName));
                        String string;
                        while ((string = bufferedReader.readLine()) != null) {
                            bufferedWriter.append(string);
                            bufferedWriter.append("\n");
                        }
                        bufferedReader.close();
                    }
                }
            }
            bufferedWriter.close();*/



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
