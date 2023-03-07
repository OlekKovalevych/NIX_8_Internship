package ua.com.alevel;

import ua.com.alevel.endoflessons.EndOfLessons;
import ua.com.alevel.lineone.LineOne;
import ua.com.alevel.lineserc.LineTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.lang.System.*;


public class ProgramRun {

    public static void run() {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        print();
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                final EventProcessor eventProcessor = ProgramRun.getEvent(event);
                if (eventProcessor != null) {
                    eventProcessor.process(reader, out);
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private static EventProcessor getEvent(final String event) {
        if ("1".equals(event)) {
            return new LineOne();

        }

        if ("2".equals(event)) {
            return new LineTwo();
        }
        if ("3".equals(event)) {
            return new EndOfLessons();
        }

        if ("4".equals(event)) {
            exit(0);
        }
        return null;
    }

    public static void print() {
        out.println("If you need the first task, choose 1");
        for (final String s : Arrays.asList("If you need a second task, choose 2 ", "If you need a third task, choose 3 ", "If you want to finish, select 4", "Select you event: ")) {
            out.println(s);
        }
    }
}
