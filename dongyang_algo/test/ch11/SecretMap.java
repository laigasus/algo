package test.ch11;

import java.util.ArrayList;
import java.util.List;

public class SecretMap {
    public static void main(String[] args) {
        int[] arr1 = { 9, 20, 28, 18, 18 };
        int[] arr2 = { 30, 1, 21, 17, 28 };
        List<String> map = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            String str=Integer.toBinaryString(arr1[i] | arr2[i]);
            str=str.replaceAll("1", "#");
            str=str.replaceAll("0", " ");
            map.add(str);
        }

        map.forEach(str -> System.out.println(str));
    }
}
