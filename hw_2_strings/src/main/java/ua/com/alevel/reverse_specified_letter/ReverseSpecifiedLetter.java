package ua.com.alevel.reverse_specified_letter;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

import static ua.com.alevel.ReverseStringUtil.reverseSpecifiedLetterInString;

public class ReverseSpecifiedLetter implements EventProcessor {

    public void process(Reader reader, PrintStream writer) {
        Scanner str = new Scanner(System.in);

        writer.println("Enter a character");
        String userString = str.nextLine();
        writer.println("Enter first letter number");

        int firstArrayInArray = str.nextInt();

        writer.println("Enter last letter number");
        int lastArrayInArray = str.nextInt();
        writer.println(reverseSpecifiedLetterInString(userString, firstArrayInArray, lastArrayInArray));
        writer.println();
        writer.println("Select you event: ");
    }
}
