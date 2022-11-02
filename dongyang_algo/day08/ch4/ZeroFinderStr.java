package day08.ch4;

import java.util.ArrayList;
import java.util.Arrays;

// 시간 복잡도 O(N)
public class ZeroFinderStr {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(6, 0, 8, 2, 3, 0, 4, 0, 1));
        var cnt = arr.stream().filter(i -> i == 0).count();
        arr = new ArrayList<>(arr.stream().filter(i -> i != 0).toList());

        for(var i=0; i<cnt; i++){
            arr.add(0);
        }
        System.out.println(arr);
    }
}