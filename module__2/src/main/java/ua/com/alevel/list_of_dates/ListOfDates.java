package ua.com.alevel.list_of_dates;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import static ua.com.alevel.utils.MyUtils.readFileLine;
import static ua.com.alevel.utils.MyUtils.writeInFile;

public final class ListOfDates {

    public static final Pattern PATTERN_ONE = Pattern.compile("(?i).*[a-zа-я].*");
    private static final String READ_FILE_NAME = "input_list_of_dates.txt";
    private static final String WRITE_FILE_NAME = "output_list_of_dates.txt";
    private static final int STRING_LENGTH = 12;
    private static final int SIZE_YEAR = 4;
    private static final int COUNT_MONTH = 12;
    private static final int DAY_IN_MONTH = 31;
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Zа-яА-Я]+");
    private static final String USER_EXCEPTIONS_ONE = "->Enter from the beginning of the line without spaces. Incorrect input format in this date or incorrect day or month. Example type: {2020/04/01}";

    private ListOfDates() { }

    public static void run() throws IOException {
        List<String> arrayList = (readFileLine(ListOfDates.READ_FILE_NAME));
        String bufferLine;
        for (int i = 0; i < arrayList.size(); i++) {
            bufferLine = arrayList.get(i);
            if (bufferLine.isBlank() || ListOfDates.STRING_LENGTH < bufferLine.length()) {
                arrayList.set(i, ListOfDates.USER_EXCEPTIONS_ONE);
            } else {
                bufferLine = ListOfDates.stringTransformation(bufferLine);
                arrayList.set(i, bufferLine);
            }
        }
        writeInFile(ListOfDates.WRITE_FILE_NAME, arrayList);
    }

    private static String removeCharAt(String line) {
        StringBuilder clearLine = new StringBuilder();
        clearLine.append(line);
        clearLine.deleteCharAt(0);
        clearLine.deleteCharAt(clearLine.length() - 1);
        return clearLine.toString();
    }

    private static String stringTransformation(String line) {
        StringBuilder result = new StringBuilder();
        try {
            String[] array;
            array = ListOfDates.removeCharAt(line).split("/");
            int elementOfArrayYear = 0;
            int elementOfArrayMonth = 0;
            for (int i = 0; i < array.length; i++) {
                if (ListOfDates.SIZE_YEAR == array[i].length()) {
                    elementOfArrayYear = i;
                }
                if (ListOfDates.SIZE_YEAR > array[i].length() && ListOfDates.COUNT_MONTH >= Integer.parseInt(array[i])) {
                    elementOfArrayMonth = i;
                }
            }
            int elementOfArrayDay = array.length - (elementOfArrayMonth + elementOfArrayYear);

            if (ListOfDates.DAY_IN_MONTH >= Integer.parseInt(array[elementOfArrayDay]) && ListOfDates.COUNT_MONTH >= Integer.parseInt(array[elementOfArrayMonth])) {
                for (int i : new int[]{elementOfArrayYear, elementOfArrayMonth, elementOfArrayDay}) {
                    result.append(array[i]);
                }
            }
            if (result.toString().isBlank() || ListOfDates.PATTERN_ONE.matcher(result.toString()).matches() || ListOfDates.PATTERN.matcher(result.toString()).matches()) {
                resultUserException(line, result, USER_EXCEPTIONS_ONE);
            }

        } catch (Exception exception) {
            resultUserException(line, result, USER_EXCEPTIONS_ONE);
        }
        return result.toString();
    }

    private static void resultUserException(String line, StringBuilder result, String userExceptions) {
        result.delete(0, result.length());
        result.append(line);
        result.append(userExceptions);
    }
}
