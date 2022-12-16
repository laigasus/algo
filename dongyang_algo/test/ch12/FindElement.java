package test.ch12;

import java.util.Arrays;
import java.util.List;

public class FindElement {
    public static void main(String[] args) {
        int idx = -1;
        List<Integer> arr = Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9);
        int maxIdx = arr.indexOf(arr.stream().mapToInt(i -> i).max().getAsInt());
        int minIdx = arr.indexOf(arr.stream().mapToInt(i -> i).min().getAsInt());

        if (maxIdx > minIdx) {
            int[] arr2 = Arrays.copyOfRange(arr.stream().mapToInt(i -> i).toArray(), minIdx, maxIdx);

            for (int i = 0; i < arr2.length - 1; i++) {
                if (arr2[i] > arr2[i + 1]) {
                    arr2[i + 1] = arr2[i];
                } else {
                    idx = arr.indexOf(arr2[i]);
                }
            }
        }

        System.out.println("index>" + idx);
    }
}
