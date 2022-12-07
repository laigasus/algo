package day15.ch11;

import java.util.ArrayList;
import java.util.List;

public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int arr1[] = { 9, 20, 28, 18, 18 };
        int arr2[] = { 30, 1, 21, 17, 28 };
        System.out.println(decode(n, arr1, arr2));
    }

    public static List<String> decode(int n, int[] arr1, int[] arr2) {
        List<String> rs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr1[i] | arr2[i]) + "";
            str = str.replaceAll("1", "#");
            str = str.replaceAll("0", " ");
            rs.add(str);
        }
        return rs;
    }
}
