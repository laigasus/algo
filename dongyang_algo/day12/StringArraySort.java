package day12;

import java.util.Arrays;
import java.util.List;

public class StringArraySort {
    public static void main(String[] args) {
        String str = "K1KA5CB7";
        List<String> arr = Arrays.asList(str.split(""));
        List<String> stringArr = arr.stream().filter(i -> Character.isLetter(i.charAt(0))).sorted().toList();
        String stringSorted = String.join("", stringArr);
        int sum = str.chars().filter(Character::isDigit).map(a -> Character.digit(a, 10)).sum();
        System.out.println(stringSorted + sum);
    }
}
