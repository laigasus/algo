package test.ch12;

import java.util.List;
import java.util.stream.Collectors;

public class StringArraySort {
    public static void main(String[] args) {
        String str = "K1KA5CB7";
        int sumNum = str.chars().filter(Character::isDigit).map(i -> Character.digit(i, 10)).sum();
        List<String> arr = str.chars().filter(Character::isLetter).mapToObj(i -> String.valueOf((char) i)).sorted()
                .collect(Collectors.toList());

        System.out.println(String.join("", arr) + sumNum);
    }
}
