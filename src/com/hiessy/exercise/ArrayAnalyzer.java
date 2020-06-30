package com.hiessy.exercise;

import java.util.HashMap;

public class ArrayAnalyzer {

    /**
     * Returns true if a sum of two integers exist inside storedNumbers that add up to number
     *
     * @param number
     * @param storedNumbers
     * @return
     */
    public static boolean doesSumExistArray(int number, int[] storedNumbers) {
        for (int x : storedNumbers)
            for (int i = 1; i < storedNumbers.length; i++)
                if (number == x + storedNumbers[i])
                    return true;
        return false;
    }

    /**
     * Returns true if a sum of two integers exist inside storedNumbers that add up to number
     *
     * @param number
     * @param storedNumber
     * @return
     */
    public static boolean doesSumExistHashMap(int number, HashMap<Integer, Integer> storedNumber) {
        for (int n : storedNumber.keySet()) {
            if (storedNumber.get(number - n) != null)
                return true;
        }
        return false;
    }
}
