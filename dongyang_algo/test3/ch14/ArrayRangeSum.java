package test3.ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRangeSum {
    public static void main(String[] args) {
        int right = 5, left = 2;
        int[] arr = { 10, 20, 30, 40, 50 };
        Arrays.parallelPrefix(arr, Integer::sum);
        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        list.add(0, 0);
        System.out.println(list.get(right) - list.get(left - 1));
    }
}
