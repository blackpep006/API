package task4;

import common.Helper;
import task4.StringBuilderProcess;
import java.util.Scanner;
import common.CustomException;

public class StringBuilderRunner {
    StringBuilderProcess process;
    Scanner input;

    public StringBuilderRunner() {
        process = new StringBuilderProcess();
        input = new Scanner(System.in);
    }

    public void q1() throws CustomException {
        StringBuilder newString = process.createBuilder();
        System.out.println("Length is " + process.length(newString));
        String inputString = Helper.getString();
        process.addString(newString, inputString);
        System.out.println("Length after appending of " + newString + " is " + process.length(newString));
    }

    public void q2() throws CustomException {
        StringBuilder newString = process.createBuilder(Helper.getString());
        String delimiter = "#";
        String[] inputStrings = new String[4];
        for (int i = 0; i < 4; i++) {
            inputStrings[i] = Helper.getString();
        }
        process.addStrings(newString, inputStrings, delimiter);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
    }

    public void q3() throws CustomException {
        String[] inputStrings = new String[2];
        for (int i = 0; i < 2; i++) {
            inputStrings[i] = Helper.getString();
        }
        int lengthOfString1 = inputStrings[0].length();
        String delimiter = "  ";
        StringBuilder newString = process.createBuilder();
        process.addStrings(newString, inputStrings, delimiter);
        process.addStringAtIndex(lengthOfString1 + 1, newString, Helper.getString());
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
    }

    public void q4() throws CustomException {
        int size = 2;
        String[] inputStrings = new String[size];
        for (int i = 0; i < size; i++) {
            inputStrings[i] = Helper.getString();
        }
        int lengthOfString1 = inputStrings[0].length();
        String delimiter = " ";
        StringBuilder newString = process.createBuilder();
        process.addStrings(newString, inputStrings, delimiter);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
        process.delete(0, lengthOfString1 + 1, newString);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
    }

    public void q5() throws CustomException {
        int size = 3;
        String[] inputStrings = new String[size];
        for (int i = 0; i < size; i++) {
            inputStrings[i] = Helper.getString();
        }
        String delimiter = " ";
        StringBuilder newString = process.createBuilder();
        process.addStrings(newString, inputStrings, delimiter);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
        Character newDelimiter = '-';
        process.change(newString, ' ', newDelimiter);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
    }

    public void q6() throws CustomException {
        int size = 3;
        String[] inputStrings = new String[size];
        for (int i = 0; i < size; i++) {
            inputStrings[i] = Helper.getString();
        }
        String delimiter = " ";
        StringBuilder newString = process.createBuilder();
        process.addStrings(newString, inputStrings, delimiter);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
        process.reverse(newString);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
    }

    public void q7() throws CustomException {
        System.out.print("Enter a String of 10 char :");
        StringBuilder newString = process.createBuilder(Helper.getString());
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
        process.delete(6, 8 + 1, newString);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
    }

    public void q8() throws CustomException {
        System.out.print("Enter a String of 10 char :");
        StringBuilder newString = process.createBuilder();
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
        String replaceWith = "XYZ";
        process.replace(6, 8 + 1, newString, replaceWith);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
    }

    public void q9() throws CustomException {
        int size = 3;
        String[] inputStrings = new String[size];
        for (int i = 0; i < size; i++) {
            inputStrings[i] = Helper.getString();
        }
        String delimiter = "#";
        StringBuilder newString = process.createBuilder();
        process.addStrings(newString, inputStrings, delimiter);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
        System.out.println("The index of first # is " + process.indexOf(newString, delimiter));
    }

    public void q10() throws CustomException {
        int size = 3;
        String[] inputStrings = new String[size];
        for (int i = 0; i < size; i++) {
            inputStrings[i] = Helper.getString();
        }
        String delimiter = "#";
        StringBuilder newString = process.createBuilder();
        process.addStrings(newString, inputStrings, delimiter);
        System.out.println("The String is " + newString + " and length is " + process.length(newString));
        System.out.println("The index of last # is " + process.lastIndexOf(newString, delimiter));
    }

    public static void main(String[] args) {
        StringBuilderRunner runner = new StringBuilderRunner();
        int a = 1;
        while (a != -1) {
            System.out.print("Enter 1 to 10: ");
            a = runner.input.nextInt();
            try {
                switch (a) {
                    case 1: runner.q1(); break;
                    case 2: runner.q2(); break;
                    case 3: runner.q3(); break;
                    case 4: runner.q4(); break;
                    case 5: runner.q5(); break;
                    case 6: runner.q6(); break;
                    case 7: runner.q7(); break;
                    case 8: runner.q8(); break;
                    case 9: runner.q9(); break;
                    case 10: runner.q10(); break;
                    case -1: break;
                    default: System.out.println("Enter valid number");
                }
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
    }
}
