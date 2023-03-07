package ua.com.alevel.lineserc;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LineTwo implements EventProcessor {

    private static final int B = 26;

    @Override
    public void process(Reader reader, PrintStream writer) {
        writer.println("Enter a character");
        Scanner con = new Scanner(System.in);
        String s = con.nextLine();
        s = s.replaceAll("[^A-Za-zА-Яа-я]", "");
        writer.println(s);
        String str = s;
        int len = str.length();
        Map<Character, Integer> numChars = new HashMap<Character, Integer>(Math.min(len, B));
        for (int i = 0; i < len; ++i) {
            char charAt = str.charAt(i);
            if (!numChars.containsKey(charAt)) {
                numChars.put(charAt, 1);
            } else {
                numChars.put(charAt, numChars.get(charAt) + 1);
            }
        }
        writer.println(numChars);
        writer.println();
        writer.println("Select you event: ");
    }
}



