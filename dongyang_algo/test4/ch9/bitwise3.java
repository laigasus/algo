package test4.ch9;

public class bitwise3 {
    public static void main(String[] args) {
        int n = 11;
        String str = new StringBuilder(Integer.toBinaryString(n)).reverse().toString().replaceFirst("0", "1");
        str = new StringBuilder(str).reverse().toString();
        n = Integer.parseInt(str, 2);
        System.out.println(n);
    }
}
