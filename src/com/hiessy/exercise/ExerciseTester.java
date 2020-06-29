package com.hiessy.exercise;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ExerciseTester {

    static String trueInput = "{asd}[asd[asd]]";
    static String falseInput = "{asd}[asd}";
    static int[] numbers = new int[]{2, 12, 12, 12, 3, 3};
    static HashMap<Integer, Integer> numbersMap = new HashMap<>() {{
        put(2, 1);
        put(12, 3);
        put(3, 2);
    }};

    static MyMap<String, Integer> myMap = new MyMap<>();

    public static void main(String[] args) {

        System.out.println(BalancedString.testBalancedStringCounter(trueInput));
        System.out.println(BalancedString.testBalancedStringCounter(falseInput));
        System.out.println(BalancedString.testBalancedStringQueue(trueInput));
        System.out.println(BalancedString.testBalancedStringQueue(falseInput));

        System.out.println(ArrayAnalyzer.doesSumExistArray(15, numbers));
        System.out.println(ArrayAnalyzer.doesSumExistArray(1, new int[]{1, 1}));
        System.out.println(ArrayAnalyzer.doesSumExistHashMap(15, numbersMap));

        myMap.put(new MyTuple<>("Key1", 1));
        myMap.put(new MyTuple<>("Key2", 1));
        myMap.put(new MyTuple<>("Key3", 1));
        myMap.put(new MyTuple<>("Key4", 1));
        myMap.put(new MyTuple<>("Key5", 1));
        myMap.put(new MyTuple<>("Key6", 1));
        myMap.put(new MyTuple<>("Key7", 1));
        myMap.put(new MyTuple<>("Key8", 1));
        myMap.put(new MyTuple<>("Key9", 1));
        myMap.put(new MyTuple<>("Key10", 1));
        myMap.put(new MyTuple<>("Key11", 1));

        System.out.println("Did the map double = " + (myMap.fullSize() == 20));
        System.out.println("Did the map double = " + (myMap.occupiedSize()));
        System.out.println("Did the I find Key10 in the map " + (myMap.get("Key10").equals(1)));
        System.out.println("Did the I find Key1 in the map " + (myMap.get("Key1").equals(1)));
        try{
            myMap.get("Key12").equals(1);
        } catch (NoSuchElementException e){
            System.out.println("Did the I find Key12 in the map " + e);
        }

    }
}
