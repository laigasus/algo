package day15.ch9;

public class Bitwise3 {
    public static void main(String[] args) {
        int input = 21;
        String binStr = Integer.toBinaryString(input);
        if (binStr.contains("0")) {
            String binStrReversed = new StringBuilder(binStr).reverse().toString();
            binStrReversed = binStrReversed.replaceFirst("0", "1");
            binStr = new StringBuilder(binStrReversed).reverse().toString();
        }
        System.out.println(Integer.parseInt(binStr, 2));
    }
}
