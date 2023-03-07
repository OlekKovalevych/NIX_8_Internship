package ua.com.alevel.flip_according_to_the_word_order;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

import static ua.com.alevel.ReverseStringUtil.reverseWordString;

public class FlipAccordingToTheWordOrder implements EventProcessor {

    @Override
    public void process(Reader reader, PrintStream writer) {
        Scanner str = new Scanner(System.in);
        writer.println("Enter a character");
        String userString = str.nextLine();

        writer.println(reverseWordString(userString));
        writer.println();
        writer.println("Select you event: ");
    }
}
