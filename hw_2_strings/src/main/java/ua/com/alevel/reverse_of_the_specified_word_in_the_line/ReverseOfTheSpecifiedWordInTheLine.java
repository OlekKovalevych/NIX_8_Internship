package ua.com.alevel.reverse_of_the_specified_word_in_the_line;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

import static ua.com.alevel.ReverseStringUtil.reverseSpecifiedWordInLine;

public class ReverseOfTheSpecifiedWordInTheLine implements EventProcessor {

    @Override
    public void process(Reader reader, PrintStream writer) {
        Scanner str = new Scanner(System.in);

        writer.println("Enter a character");
        String userString = str.nextLine();

        writer.println("Enter word number");
        int wordInArray = str.nextInt();

        writer.println(reverseSpecifiedWordInLine(userString, wordInArray - 1));
        writer.println();
        writer.println("Select you event: ");
    }
}
