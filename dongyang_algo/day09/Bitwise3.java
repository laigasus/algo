package day09;

public class Bitwise3 {
    public static void main(String[] args) {
        var input = 6;
        var binStr = Integer.toBinaryString(input);
        if (binStr.contains("0")) {
            var binStrReversed = new StringBuilder(binStr).reverse().toString();
            binStrReversed = binStrReversed.replaceFirst("0", "1");
            binStr = new StringBuilder(binStrReversed).reverse().toString();
        }
        System.out.println(Integer.parseInt(binStr, 2));
    }
}