package day15.ch12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindElement {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9);
        List<Integer> arr2 = new ArrayList<>(arr);
        Collections.sort(arr2);
        int median = arr2.get((int) arr2.size() / 2);
        System.out.println("index>" + arr.indexOf(median));
    }
}
