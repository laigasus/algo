package day08.ch3;

import java.util.Arrays;

//시간 복잡도 O(N)
public class ATM {
    public static void main(String[] args) {
        int sum = 0;
        int[] arr = { 3, 1, 4, 3, 2 };
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            //Arrays.copyOf() > 배열 중 n개 불러오기
            int[] copyArr = Arrays.copyOf(arr, i+1);
            sum += Arrays.stream(copyArr).sum();
        }
        System.out.println("최소값>" + sum);
    }
}
