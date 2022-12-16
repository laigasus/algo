package test2.ch12;

public class StringArraySort {
    public static void main(String[] args) {
        String str = "K1KA5CB7";
        int num = str.chars().filter(Character::isDigit).map(i -> Character.digit(i, 10)).sum();
        str = String.join("",
                str.chars().filter(Character::isLetter).mapToObj(i -> String.valueOf((char) i)).sorted().toList());
        System.out.println(str + num);
    }
}
