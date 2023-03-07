package ua.com.alevel.first_unique_name;

import ua.com.alevel.utils.MyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ua.com.alevel.utils.MyUtils.readingFileByWords;

public final class FirstUniqueName {

    private static final String FILE_READ_NAME = "input_first_unique_name.txt";
    private static final String FILE_WRITE_NAME = "output_first_unique_name.txt";

    private FirstUniqueName() { }

    public static void run() throws IOException {
       List<String> resultList = new ArrayList<>();
        resultList.add(FirstUniqueName.searchFirstUniqueName((readingFileByWords(FirstUniqueName.FILE_READ_NAME))) + "  <-It is you result");
        MyUtils.writeInFile(FirstUniqueName.FILE_WRITE_NAME, resultList);
    }

    private static String searchFirstUniqueName(List<String> listInputs) {
        List<String> listOutputs = new ArrayList<>();
        String result;
        for (String value : listInputs) {
            if (Collections.frequency(listInputs, value) == 1) {
                listOutputs.add(value);
            }
        }
        listOutputs.remove(0);
        if (listOutputs.isEmpty()) {
            result = "No unique names ";
        } else {
            result = listOutputs.get(0);
        }
        return result;
    }
}
