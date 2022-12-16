package test2.ch10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateLargestValue {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("75", "68", "21", "12", "10", "7");
        Collections.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        System.out.println(String.join("", arr));
    }
}
