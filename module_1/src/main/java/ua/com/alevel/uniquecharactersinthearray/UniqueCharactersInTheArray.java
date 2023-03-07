package ua.com.alevel.uniquecharactersinthearray;


import ua.com.alevel.EventProcessor;
import ua.com.alevel.horsemove.HorseMove;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class UniqueCharactersInTheArray implements EventProcessor {

    @Override
    public void process(Reader reader, PrintStream writer) {
        Scanner str = new Scanner(System.in);
        writer.println("Enter the size of the array (positive number, without spaces and characters) that is to be created");
        String userLine = str.nextLine();

        if (checkingTheString(userLine) == false) {
            writer.println("Next time enter a number positive number in a string without spaces and characters");
            HorseMove.printEnd();
            return;
        }

        int sizeArray = stringToInt(userLine);

        int userArray[];
        userArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            writer.println("Enter the " + (i + 1) + " element:");
            userLine = str.nextLine();
            if (checkingTheString(userLine) == false) {
                writer.println("Next time enter a number positive number in a string without spaces and characters");
                HorseMove.printEnd();
                return;
            } else {
                userArray[i] = stringToInt(userLine);
            }
        }
        writer.println("The array created is " + Arrays.toString(userArray));
        int count = 0;
        int numberRepetitionCounter = 0;
        for (int i = 0; i < userArray.length; i++) {
            for (int j = i + 1; j < userArray.length; j++) {
                if (userArray[i] == userArray[j]) {
                    numberRepetitionCounter++;
                    break;
                }
            }

        }
        writer.println("There are unique numbers in the array: " + (sizeArray - numberRepetitionCounter));
        HorseMove.printEnd();
    }

    public static boolean checkingTheString(String userLine) {
        boolean a = true;
        for (int i = 0; i < userLine.length(); i++) {
            if (userLine.charAt(i) < '0' || userLine.charAt(i) > '9') {
                System.out.println("Error");
                a = false;
            }
        }
        return a;
    }

    public static int stringToInt(String userString) {
        int userInt = Integer.parseInt(userString);
        return userInt;
    }
}





