package ua.com.alevel.endoflessons;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class EndOfLessons implements EventProcessor {

    public void process(Reader reader, PrintStream writer) {
        final int b=60;
        writer.println("Enter a character 1-10");
        final Scanner integers = new Scanner(System.in);
        int a = integers.nextInt();
        a = EndOfLessons.getAnInt(a);
        writer.print(a / b + 9);
        writer.print(":");
        writer.print(a % b);
        writer.println();
        writer.println("Select you event: ");
    }

    private static int getAnInt(final int a) {
        return a * 45 + (a / 2) * 5 + ((a + 1) / 2 - 1) * 15;
    }
}
