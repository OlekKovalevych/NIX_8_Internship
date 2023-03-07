package ua.com.alevel.lineone;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class LineOne implements EventProcessor {

    @Override
    public void process(Reader reader, PrintStream writer) {
        int sum = 0;
        Scanner str = new Scanner(System.in);
        writer.println("Enter a character");
        String a = str.next();

        for (int i = 0; i < a.length(); i++) {
            if (Character.isDigit(a.charAt(i))) {
                sum = sum + Integer.parseInt(a.charAt(i) + "");
            }
        }
        writer.println("sum is:" + sum);
        writer.println();
        writer.println("Select you event: ");
    }
}
