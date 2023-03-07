package ua.com.alevel;

import ua.com.alevel.base_reverse.BaseReverse;
import ua.com.alevel.flip_according_to_the_word_order.FlipAccordingToTheWordOrder;
import ua.com.alevel.reverse_of_the_specified_word_in_the_line.ReverseOfTheSpecifiedWordInTheLine;
import ua.com.alevel.reverse_specified_letter.ReverseSpecifiedLetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.lang.System.*;

public class ProgramRun {

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        ProgramRun.print();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                EventProcessor eventProcessor = getEvent(event);
                if (eventProcessor != null) {
                    eventProcessor.process(reader, out);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static EventProcessor getEvent(String event) {
        if ("1".equals(event)) {
            return new BaseReverse();
        }

        if ("2".equals(event)) {
            return new FlipAccordingToTheWordOrder();
        }
        if ("3".equals(event)) {
            return new ReverseOfTheSpecifiedWordInTheLine();
        }
        if ("4".equals(event)) {
            return new ReverseSpecifiedLetter();
        }

        if ("5".equals(event)) {
            exit(0);
        }
        return null;
    }

    private static void print() {
        out.println("If you need BaseReverse, choose 1");
        for (String s : Arrays.asList("If you need a reverse by words, choose 2 ", "If you need a choose a word to reverse, choose 3 ", "If you need areverse of letters in a lineselect 4 ", "If you want to finish, select 5", "Select you event: ")) {
            out.println(s);
        }
    }
}
