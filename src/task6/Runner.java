package task6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import common.Helper;
import common.CustomException;

public class Runner {
    Process process;
    Scanner input;
    ArrayListReflection reff;
    public Runner() {
        process = new Process();
        input = new Scanner(System.in);
        reff=new ArrayListReflection();
    }

    public void q1() throws CustomException {
        List<Integer> list = reff.createList();
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q2() throws CustomException {
        List<String> list = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getString());
        }
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q3() throws CustomException {
        List<Integer> list = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getInteger());
        }
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q4() throws CustomException {
        List<Custom> list = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(list, new Custom());
        }
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q5() throws CustomException {
        List<Object> list = process.createList();
        int size = 2;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getString());
        }
        size = 3;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getInteger());
        }
        size = 2;
        for (int i = 0; i < size; i++) {
            process.add(list, new Custom());
        }
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q6() throws CustomException {
        List<String> list = process.createList();
        int size = 4;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getString());
        }
        System.out.println("index is " + process.indexOf(list, Helper.getString()));
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q7() throws CustomException {
        List<String> list = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getString());
        }
        Iterator<String> iterator = process.iterator(list);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q8() throws CustomException {
        List<String> list = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getString());
        }
        System.out.println("Object at the given index is " + process.get(list, Helper.getInteger()));
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q9() throws CustomException {
        List<String> list = process.createList();
        int size = 4;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getString());
        }
        String inputString = Helper.getString();
        System.out.println("first index is " + process.indexOf(list, inputString));
        System.out.println("last index is " + process.lastIndexOf(list, inputString));
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q10() throws CustomException {
        List<String> list = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getString());
        }
        String inputString = Helper.getString();
        int addAt = 2;
        process.add(addAt, inputString, list);
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q11() throws CustomException {
        List<String> firstList = process.createList();
        int size = 10;
        for (int i = 0; i < size; i++) {
            process.add(firstList, Helper.getString());
        }
        List<String> secondList = process.subList(3, 8 + 1, firstList);
        System.out.println(secondList);
        System.out.println("Length is " + process.length(secondList));
    }

    public void q12() throws CustomException {
        List<String> firstList = process.createList();
        int size = 3;
        for (int i = 0; i < size; i++) {
            process.add(firstList, Helper.getString());
        }
        List<String> secondList = process.createList();
        size = 5;
        for (int i = 0; i < size; i++) {
            process.add(secondList, Helper.getString());
        }
        List<String> thirdList = process.createList();
        process.addAll(firstList, thirdList);
        process.addAll(secondList, thirdList);
        System.out.println(thirdList);
        System.out.println("Length is " + process.length(thirdList));
    }

    public void q13() throws CustomException {
        List<String> firstList = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(firstList, Helper.getString());
        }
        List<String> secondList = process.createList();
        size = 3;
        for (int i = 0; i < size; i++) {
            process.add(secondList, Helper.getString());
        }
        List<String> thirdList = process.createList();
        process.addAll(firstList, thirdList);
        process.addAll(0, secondList, thirdList);
        System.out.println(thirdList);
        System.out.println("Length is " + process.length(thirdList));
    }

    public void q14() throws CustomException {
        List<Double> list = process.createList();
        int size = 4;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getDouble());
        }
        process.remove(Helper.getInteger(), list);
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q15() throws CustomException {
        List<String> firstList = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(firstList, Helper.getString());
        }
        List<String> secondList = process.createList();
        size = 3;
        for (int i = 0; i < size; i++) {
            process.add(secondList, Helper.getString());
        }
        process.removeAll(secondList, firstList);
        System.out.println(firstList);
        System.out.println("Length is " + process.length(firstList));
    }

    public void q16() throws CustomException {
        List<String> firstList = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(firstList, Helper.getString());
        }
        List<String> secondList = process.createList();
        size = 3;
        for (int i = 0; i < size; i++) {
            process.add(secondList, Helper.getString());
        }
        process.retainAll(secondList, firstList);
        System.out.println(firstList);
        System.out.println("Length is " + process.length(firstList));
    }

    public void q17() throws CustomException {
        List<Long> list = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getLong());
        }
        process.removeAll(list, list);
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public void q18() throws CustomException {
        List<String> list = process.createList();
        int size = 5;
        for (int i = 0; i < size; i++) {
            process.add(list, Helper.getString());
        }
        System.out.println("contains is " + process.contains(list, Helper.getString()));
        System.out.println(list);
        System.out.println("Length is " + process.length(list));
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        try {
            runner.q1();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
