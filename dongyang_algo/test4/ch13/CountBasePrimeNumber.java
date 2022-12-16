package test4.ch13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountBasePrimeNumber {
    public static void main(String[] args) {
        // int input = 437674, digit = 3;
        int input = 110011, digit = 10;
        String str = Integer.toString(input, digit);
        List<String> list = new ArrayList<>(Arrays.asList(str.split("0")));
        list.removeIf(s -> s.equals("") || s.equals("1"));

        System.out.println(list.size());
    }
}
