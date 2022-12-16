package test4.ch12;

import java.util.Arrays;
import java.util.List;

public class FindElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9);
        int idx = -1;
        int minIdx = list.indexOf(list.stream().mapToInt(i -> i).min().getAsInt());
        int maxIdx = list.indexOf(list.stream().mapToInt(i -> i).max().getAsInt());

        if (maxIdx > minIdx) {
            int[] arr = Arrays.copyOfRange(list.stream().mapToInt(i -> i).toArray(), minIdx, maxIdx);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    arr[i + 1] = arr[i];
                } else {
                    idx = list.indexOf(arr[i]);
                }
            }
        }

        System.out.println(idx);
    }
}
