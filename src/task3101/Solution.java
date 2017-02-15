package task3101;

import java.io.File;

/*
Проход по дереву файлов
Проход по дереву файлов

1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя файла,
который будет содержать результат. +

2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:

2.1. Если у файла длина в байтах больше 50,
     то удалить его (используй метод FileUtils.deleteFile).

2.2. Если у файла длина в байтах НЕ больше 50,
     то для всех таких файлов:
2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘ (используй метод FileUtils.renameFile).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять «n«.
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {
        String path = ".";
        String resultFileAbsolutePath = "result.txt";

        if (args.length == 2) {
            path = args[0];
            resultFileAbsolutePath = args[1];
        }

        File file = new File(path);
        String[] directory = file.list();


        File[] files = file.listFiles();

        for (File file1 : files) {
            System.out.println("name: " + file1.getName() + " length:" + file1.length() + " Is file: " + file1.isFile() );
        }


    }

    public static void deleteFile(File file) {
        if (!file.delete())
            System.out.println("Can not delete file with name " + file.getName());
    }
}
