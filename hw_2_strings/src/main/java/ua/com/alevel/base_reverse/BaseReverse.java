package ua.com.alevel.base_reverse;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

import static ua.com.alevel.ReverseStringUtil.reverseString;

public class BaseReverse implements EventProcessor {

    @Override
    public void process(Reader reader, PrintStream writer) {
        Scanner str = new Scanner(System.in);
        writer.println("Enter a character");
        String userString = str.nextLine();

        writer.println(reverseString(userString));
        writer.println();
        writer.println("Select you event: ");
    }
}
