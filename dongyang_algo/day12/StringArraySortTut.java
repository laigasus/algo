package day12;

import java.util.ArrayList;

public class StringArraySortTut {
    public static void main(String[] args) {
        String input = "K1KA5CB7";

        ArrayList<Character> result = new ArrayList<>();
        int value = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 65 && ch <= 90) {
                result.add(ch);
            } else {
                value += ch - '0';
            }
        }
        System.out.println(result.toString()+value);
    }
}