package test3.ch12;

import java.util.List;

public class StringArraySort {
    public static void main(String[] args) {
        String str = "K1KA5CB7";
        int sum = str.chars().filter(Character::isDigit).map(i -> Character.digit((char) i, 10)).sum();
        List<String> list = str.chars().filter(Character::isLetter).mapToObj(i -> String.valueOf((char) i)).sorted()
                .toList();
        System.out.println(String.join("", list) + sum);
    }
}
