package ua.com.alevel.run;

import ua.com.alevel.math_set.MathSet;
import ua.com.alevel.math_set.MathSetImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.exit;
import static org.apache.xalan.xsltc.compiler.util.Util.println;


public class ProgramRun {
    private static MathSetImpl mathSet = new MathSetImpl<>();

    public static void run() {

        println("A new MathSet is created.");
        preview();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String event;
        try {
            while ((event = reader.readLine()) != null) {
                switch (event) {
                    case "1": {
                        println("Enter a new Integer: ");
                        String line = reader.readLine();
                        Integer integer = Integer.valueOf(line);
                        mathSet.add(integer);
                        println("New Integer was added to MathSet. Elements of the MathSet are: ");
                        println("Result: " + mathSet.toString());
                        println("Select your event:");
                    }
                    break;
                    case "2": {
                        println("Enter your Integers using space as delimiter: ");
                        String line = reader.readLine();
                        String[] array = line.split(" ");
                        ArrayList<Integer> integers = new ArrayList<>();
                        for (String s : array) {
                            Integer integer = Integer.valueOf(s);
                            integers.add(integer);
                        }
                        mathSet.add(integers.toArray(new Number[0]));
                        println("New Integers were added to MathSet.");
                        println("Result: " + mathSet.toString());
                        println("Select your event:");
                    }
                    break;
                    case "3": {
                        println("Enter Integers of the extra MathSet you want to join. Use space as delimiter: ");
                        String line = reader.readLine();
                        String[] array = line.split(" ");
                        MathSet<Integer> integers = new MathSetImpl<>();
                        for (String s : array) {
                            Integer integer = Integer.valueOf(s);
                            integers.add(integer);
                        }
                        mathSet.join(integers);
                        println("MathSets were joined.");
                        println("Result: " + mathSet.toString());
                        println("Select your event:");
                    }
                    break;
                    case "4": {
                        println("Enter Integers of the second MathSet using space as delimiter: ");
                        String line = reader.readLine();
                        String[] array = line.split(" ");
                        MathSet<Integer> integers = new MathSetImpl<>();
                        for (String s : array) {
                            Integer integer = Integer.valueOf(s);
                            integers.add(integer);
                        }
                        mathSet.intersection(integers);
                        println("Common elements of two MathSets are: ");
                        for (Number number : mathSet.toArray()) {
                            println(number + " ");
                            println("Select your event:");
                        }
                    }
                    break;
                    case "5": {
                        mathSet.sortDesc();
                        println("MathSet was sorted in a descending order.");
                        println("Result: " + mathSet);
                        println("Select your event:");
                    }
                    break;
                    case "6": {
                        println("Enter the first and the last indexes of the MathSet part you want to sort in the descending order. Use space as delimiter: ");
                        String line = reader.readLine();
                        String[] array = line.split(" ");
                        Integer start = Integer.valueOf(array[0]);
                        Integer end = Integer.valueOf(array[1]);
                        mathSet.sortDesc(start, end);
                        println("Given part of the MathSet was sorted in a descending order.");
                        println("Result: " + mathSet);
                        println("Select your event:");
                    }
                    break;
                    case "7": {
                        println("Enter the value of element from which you want to sort the MathSet in the descending order. Use space as delimiter: ");
                        String line = reader.readLine();
                        Integer integer = Integer.valueOf(line);
                        mathSet.sortDesc(integer);
                        println("Given part of the MathSet was sorted in a descending order.");
                        println("Result: " + mathSet);
                        println("Select your event:");
                    }
                    break;
                    case "8": {
                        mathSet.sortAsc();
                        println("MathSet was sorted in a ascending order.");
                        println("Result: " + mathSet);
                        println("Select your event:");
                    }
                    break;
                    case "9": {
                        println("Enter the first and the last indexes of the MathSet part you want to sort in the ascending order. Use space as delimiter: ");
                        String line = reader.readLine();
                        String[] array = line.split(" ");
                        Integer start1 = Integer.valueOf(array[0]);
                        Integer end1 = Integer.valueOf(array[1]);
                        mathSet.sortAsc(start1, end1);
                        println("Given part of the MathSet was sorted in a ascending order.");
                        println("Result: " + mathSet);
                        println("Select your event:");
                    }
                    break;
                    case "10": {
                        System.out.println("Enter the value of element from which you want to sort the MathSet in the ascending order. Use space as delimiter: ");
                        String line = reader.readLine();
                        Integer integer = Integer.valueOf(line);
                        mathSet.sortAsc(integer);
                        println("Given part of the MathSet was sorted in a ascending order.");
                        println("Result: " + mathSet);
                        println("Select your event:");
                    }
                    break;
                    case "11": {
                        println("Enter the index of element which you want to get: ");
                        String line = reader.readLine();
                        Integer integer = Integer.valueOf(line);
                        final Number number = mathSet.get(integer);
                        println("The given value is: " + number);
                        println("Select your event:");
                    }
                    break;
                    case "12": {
                        final Number max = mathSet.getMax();
                        println("The maximum value is: " + max);
                        println("Select your event:");
                    }
                    break;
                    case "13": {
                        Number min = mathSet.getMin();
                        println("The minimum value is: " + min);
                        println("Select your event:");
                    }
                    break;
                    case "14": {
                        Number average = mathSet.getAverage();
                        println("The average value is: " + average);
                        println("Select your event:");
                    }
                    break;
                    case "15": {
                        Number median = mathSet.getMedian();
                        println("The median value is: " + median);
                        println("Select your event:");
                    }
                    break;
                    case "16": {
                        Number[] numbers = mathSet.toArray();
                        println("MathSet was converted to the array");
                        println("Result: ");
                        for (Number number : numbers) {
                            println(number.toString() + " ");
                        }
                        println("");
                        println("Select your event:");
                    }
                    break;
                    case "17": {
                        println("Enter the first and the last indexes of the MathSet part you want to convert into Array. Use space as delimiter: ");
                        String line = reader.readLine();
                        String[] array = line.split(" ");
                        Integer start = Integer.valueOf(array[0]);
                        Integer end = Integer.valueOf(array[1]);
                        println("The part of the MathSet was converted to the array");
                        Number[] numbers = mathSet.toArray(start, end);
                        for (Number number : numbers) {
                            System.out.print(number.toString() + " ");
                        }
                        println("");
                        println("Select your event:");
                    }
                    break;
                    case "18": {
                        println("Enter the first and the last indexes of the MathSet part you want to cut out. Use space as delimiter: ");
                        String line = reader.readLine();
                        String[] array = line.split(" ");
                        Integer start = Integer.valueOf(array[0]);
                        Integer end = Integer.valueOf(array[1]);
                        mathSet = mathSet.cut(start, end);
                        println("A new array was created");
                        println("Result: " + mathSet);
                        println("Select your event:");
                    }
                    break;
                    case "19": {
                        mathSet.clear();
                        println("MathSet was deleted.");
                        println("Select your event:");
                    }
                    break;
                    case "20": {
                        println("Enter Integers you want to delete using space as delimiter: ");
                        String line = reader.readLine();
                        String[] array = line.split(" ");
                        ArrayList<Integer> integers = new ArrayList<>();
                        for (int i = 0; i < array.length; i++) {
                            Integer integer = Integer.valueOf(array[i]);
                            integers.add(integer);
                        }
                        mathSet.clear(integers.toArray(Integer[]::new));
                        println("Result: " + mathSet);
                        println("Select your event:");
                    }
                    break;
                    case "21": {
                        int size = mathSet.size();
                        println("The size of MathSet is " + size);
                        println("Select your event:");
                    }
                    break;
                    case "0": {
                        exit(0);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void preview() {
        println(" ");
        println("If you wont To add a new Integer, enter 1");
        println("If you wont To add a few Integers, enter 2");
        println("If you wont To join an additional MathSet, enter 3");
        println("If you wont To get inner join, enter 4");
        println("If you wont To sort elements of the MathSet in the descending order, enter 5");
        println("If you wont To sort a part of the MathSet in the descending order, enter 6");
        println("If you wont To sort a part of the MathSet from the particular element in the descending order, enter 7");
        println("If you wont To sort elements of the MathSet in the ascending order, enter 8");
        println("If you wont To sort a part of the MathSet in the ascending order, enter 9");
        println("If you wont To sort a part of the MathSet from the particular element in the ascending order, enter 10");
        println("If you wont To get at Integer by its index, enter 11");
        println("If you wont To get a maximum value from the MathSet, enter 12");
        println("If you wont To get a minimum value from the MathSet, enter 13");
        println("If you wont To get an average from the MathSet, enter 14");
        println("If you wont To get a median from the MathSet, enter 15");
        println("If you wont To convert the MathSet to Array, enter 16");
        println("If you wont To convert a part of the MathSet to Array, enter 17");
        println("If you wont To cut out a part of the MathSet, enter 18");
        println("If you wont To delete all of the elements from the MathSet, enter 19");
        println("If you wont To delete a few elements from the MathSet, enter 20");
        println("If you wont To get a size of the MathSet, enter 21");
        println("If you wont To exit task, enter 0");
        println("Select your event:");
    }
}
