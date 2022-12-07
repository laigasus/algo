package test.ch9;

public class Bitwise3 {
    public static void main(String[] args) {
        String input = Integer.toBinaryString(21);
        if (input.contains("0")) {
            input = new StringBuilder(input).reverse().toString().replaceFirst("0", "1");
            input = new StringBuilder(input).reverse().toString();
        }
        System.out.println(Integer.parseInt(input, 2));
    }
}
