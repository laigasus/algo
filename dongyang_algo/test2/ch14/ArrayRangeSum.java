package test2.ch14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRangeSum {
    public static void main(String[] args) {
        int left = 1, right = 4;
        int[] arr = { 10, 20, 30, 40, 50 };
        Arrays.parallelPrefix(arr, Integer::sum);
        List<Integer> arr2 = new ArrayList<>(Arrays.stream(arr).boxed().toList());
        arr2.add(0, 0);
        System.out.println(arr2.get(right) - arr2.get(left - 1));
    }
}
