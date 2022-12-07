package day15.ch13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountBasePrimeNumber {
    public static void main(String[] args) {
        String str = Integer.toString(110011, 10);
        List<String> arr = new ArrayList<>(Arrays.asList(str.split("0")));
        // 110011와 같이 00을 쪼갤 때 사이에 비어있음. 때문에 ""도 리스트에 추가됨
        arr.removeIf(s -> s.equals(""));
        long cnt = arr.stream().filter(s -> Integer.parseInt(s) != 1).count();
        System.out.println(cnt);
    }
}