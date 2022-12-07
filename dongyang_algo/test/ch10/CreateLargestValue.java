package test.ch10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateLargestValue {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("10", "68", "75", "7", "21", "12");
        Collections.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        System.out.println(arr);
    }
}
