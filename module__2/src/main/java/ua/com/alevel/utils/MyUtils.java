package ua.com.alevel.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MyUtils {

    public static final String FILE_NOT_FOUND = " not found";

    private MyUtils() { }

    public static List<String> readFileLine(String fileName) throws IOException {
        List<String> arrayList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while (null != (line = reader.readLine())) {
                arrayList.add(line);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            isExistFile(arrayList, fileName);
        }
        return arrayList;
    }

    public static List<String> readingFileByWords(String fileName) throws IOException {
        List<String> arrayList = readFileLine(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isBlank()) {
                continue;
            } else {
                stringBuilder.append(" ");
                stringBuilder.append(arrayList.get(i));
            }
        }
        String[] stringArray;
        stringArray = stringBuilder.toString().split(" ");
        arrayList.clear();
        arrayList = Arrays.asList(stringArray);
        return arrayList;
    }

    public static String writeInFile(String fileName, List<String> arrayList) {
        try {
            FileWriter writer = new FileWriter(fileName, false);
            for (int i = 0; i < arrayList.size(); i++) {
                writer.write(arrayList.get(i));
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return "file not write";
        }
        return "file write";
    }

    public static void isExistFile(List<String> arrayList, String filename) {
        if (arrayList.isEmpty()) {
            System.out.println(filename + MyUtils.FILE_NOT_FOUND);
        }
    }
}
