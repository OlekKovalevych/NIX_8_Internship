package ua.com.alevel.theareaoftriangle;


import ua.com.alevel.EventProcessor;
import ua.com.alevel.horsemove.HorseMove;
import ua.com.alevel.uniquecharactersinthearray.UniqueCharactersInTheArray;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class TheAreaOfTheTriangle implements EventProcessor {

    @Override
    public void process(Reader reader, PrintStream writer) {
        Scanner str = new Scanner(System.in);
        String coordinateAX;
        String coordinateAY;
        String coordinateBX;
        String coordinateBY;
        String coordinateCX;
        String coordinateCY;

        writer.println("It is necessary to enter numbers without symbols and spaces");
        writer.println("Enter the a positive integer coordinate A (X)");
        coordinateAX = str.nextLine();
        writer.println("Enter the a positive integer coordinate A (Y)");
        coordinateAY = str.nextLine();
        writer.println("Enter the a positive integer coordinate B (X)");
        coordinateBX = str.nextLine();
        writer.println("Enter the a positive integer coordinate B (Y)");
        coordinateBY = str.nextLine();
        writer.println("Enter the a positive integer coordinate C (X)");
        coordinateCX = str.nextLine();
        writer.println("Enter the a positive integer coordinate C (Y)");
        coordinateCY = str.nextLine();

        Coordinate A = new Coordinate();
        Coordinate B = new Coordinate();
        Coordinate C = new Coordinate();

        if (UniqueCharactersInTheArray.checkingTheString(coordinateAX) == true
                && UniqueCharactersInTheArray.checkingTheString(coordinateAY) == true
                && UniqueCharactersInTheArray.checkingTheString(coordinateBX) == true
                && UniqueCharactersInTheArray.checkingTheString(coordinateBY) == true
                && UniqueCharactersInTheArray.checkingTheString(coordinateCX) == true
                && UniqueCharactersInTheArray.checkingTheString(coordinateCY) == true) {

            A.setX(Integer.parseInt(coordinateAX));
            A.setY(Integer.parseInt(coordinateAY));
            B.setX(Integer.parseInt(coordinateBX));
            B.setY(Integer.parseInt(coordinateBY));
            C.setX(Integer.parseInt(coordinateCX));
            C.setY(Integer.parseInt(coordinateCY));
            if (TriangleAreaCalculator.calculateArea(A, B, C) == 0) {
                writer.println("There is no such triangle");
                HorseMove.printEnd();
                return;
            } else {
                writer.println("Square :" + TriangleAreaCalculator.calculateArea(A, B, C) + "M^2");
            }
        } else {
            writer.println("Next time enter a integer number without symbols and spaces");
            HorseMove.printEnd();
            return;
        }
        HorseMove.printEnd();
    }
}
