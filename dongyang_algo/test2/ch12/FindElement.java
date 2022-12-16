package test2.ch12;

import java.util.Arrays;
import java.util.List;

public class FindElement {
    public static void main(String[] args) {
        int idx = -1;
        List<Integer> list = Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9);
        int minIdx = list.indexOf(list.stream().mapToInt(i -> i).min().getAsInt());
        int maxIdx = list.indexOf(list.stream().mapToInt(i -> i).max().getAsInt());
        if (maxIdx > minIdx) {
            int[] arr2 = Arrays.copyOfRange(list.stream().mapToInt(i -> i).toArray(), minIdx, maxIdx);
            for (int i = 0; i < arr2.length - 1; i++) {
                if (arr2[i] > arr2[i + 1]) {
                    arr2[i + 1] = arr2[i];
                } else {
                    idx = list.indexOf(arr2[i]);
                }
            }
        }
        System.out.println(idx);
    }
}
