package com.hiessy.exercise;

import java.util.*;

/**
 * create a method that given a string will return true or false if the brackets are balanced or no
 * for example true for (asd)[asd[asd]]
 * false for {asd[}[asd)
 */
public class BalancedString {

    private static Character closingCurlyBracket = '}';
    private static Character closingBracket = ']';
    private static Character openingCurlyBracket = '{';
    private static Character openingBracket = '[';

    /**
     * Returns true if the string has brackets in the correct order
     * @param input
     * @return
     */
    public static boolean testBalancedStringQueue(String input) {
        Queue<Character> brackets = Collections.asLifoQueue(new LinkedList<Character>()); //[[
        for (char c : input.toCharArray()) {
            if (c == openingCurlyBracket)
                brackets.add(c);
            else if (c == closingCurlyBracket) {
                Character n = brackets.poll();
                if (n != openingCurlyBracket)
                    return false;
            } else if (c == openingBracket)
                brackets.add(c);
            else if (c == closingBracket){
                Character n = brackets.poll();
                if (n != openingBracket)
                    return false;
            }
        }
        return brackets.isEmpty();
    }

    /**
     * Returns false is the string has brackets in incorrect order
     * @param input
     * @return
     */
    public static boolean testBalancedStringCounter(String input) {
        int curlyBracketsCounter = 0;
        int bracketsCounter = 0;
        for (char c : input.toCharArray()) {
            if (c == openingBracket)
                bracketsCounter++;
            else if (c == closingBracket)
                bracketsCounter--;
            else if (c == openingCurlyBracket)
                curlyBracketsCounter++;
            else if (c == closingCurlyBracket)
                curlyBracketsCounter--;
        }
        return (curlyBracketsCounter == 0 && bracketsCounter == 0);
    }

}
