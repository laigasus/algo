package test2.ch9;

public class Bitwise3 {
    public static void main(String[] args) {
        int n = 21;
        String str = new StringBuilder(Integer.toBinaryString(n)).reverse().toString().replaceFirst("0", "1");
        str = new StringBuilder(str).reverse().toString();
        System.out.println(Integer.parseInt(str, 2));
    }
}
