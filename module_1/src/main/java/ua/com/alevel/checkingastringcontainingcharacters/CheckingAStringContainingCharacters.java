package ua.com.alevel.checkingastringcontainingcharacters;

import ua.com.alevel.EventProcessor;
import ua.com.alevel.horsemove.HorseMove;

import java.io.PrintStream;
import java.io.Reader;
import java.util.*;

public class CheckingAStringContainingCharacters implements EventProcessor {

    public void process(Reader reader, PrintStream writer) {
        Scanner str = new Scanner(System.in);
        writer.println("Enter the text with in the correct order of closing brackets, or don't enter anything");
        String userLine = str.nextLine();
        if (isValidBrackets(userLine) == true) {
            writer.println("Your string passed the test perfectly!");
        } else {
            writer.println(" Unfortunately, your string failed validation!");
            HorseMove.printEnd();
            return;
        }
        HorseMove.printEnd();
    }


    private static boolean isValidBrackets(String userLine) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Deque<Character> stack = new LinkedList<>();
        for (char charUserLine : userLine.toCharArray()) {
            if (brackets.containsValue(charUserLine)) {

                stack.push(charUserLine);
            } else if (brackets.containsKey(charUserLine)) {

                if (stack.isEmpty() || stack.pop() != brackets.get(charUserLine)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
