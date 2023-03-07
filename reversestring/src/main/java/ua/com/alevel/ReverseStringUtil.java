package ua.com.alevel;

public final class ReverseStringUtil {

    public static String reverseString(String usersString) {
        char[] array = usersString.toCharArray();
        String reverseUsersString = "";

        for (int i = array.length - 1; i >= 0; i--) {
            reverseUsersString = reverseUsersString + array[i];
        }
        return reverseUsersString + " ";
    }

    public static String reverseWordString(String usersString) {
        String reverseUsersString = "";
        String[] array = usersString.split("\\s+");
        for (int i = 0; i < array.length; i++) {
            reverseUsersString = reverseUsersString + reverseString(array[i] + " ");
        }
        return reverseUsersString + " ";
    }

    public static String reverseSpecifiedWordInLine(String usersString, int indexArray) {
        String reverseUsersString = "";
        String[] array = usersString.split("\\s+");
        if (indexArray <= array.length && indexArray >= 1) {
            for (int i = 0; i < array.length; i++) {
                if (i == indexArray) {
                    reverseUsersString = reverseUsersString + reverseString(array[i]);
                } else {
                    reverseUsersString = reverseUsersString + array[i] + " ";
                }
            }
        } else {
            return "An existing word number has been entered";
        }
        return reverseUsersString;
    }

    public static String reverseSpecifiedLetterInString(String usersString, int indexLetterArrayFirst, int indexLetterArrayLast) {
        String reverseUsersString = "";
        char[] array = usersString.toCharArray();
        if (сheckingTheIndex(indexLetterArrayFirst, array.length) == true && сheckingTheIndex(indexLetterArrayLast, array.length) == true) {
            for (int i = 0; i < indexLetterArrayFirst; i++) {
                reverseUsersString = reverseUsersString + array[i];
            }
            for (int i = indexLetterArrayLast; i >= indexLetterArrayFirst; i--) {
                reverseUsersString = reverseUsersString + array[i];
            }
            for (int i = indexLetterArrayLast; i < array.length; i++) {
                reverseUsersString = reverseUsersString + array[i];
            }
        } else {
            return " The entered element numbers do not match the existing ones in the array";
        }
        return reverseUsersString + " ";
    }

    //if(indexLetterArrayFirst<=array.length && indexLetterArrayLast<=array.length && indexLetterArrayLast>=0 && indexLetterArrayFirst=>0)
    public static boolean сheckingTheIndex(int index, int size) {
        final boolean result;
        if (index <= size && index >= 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
