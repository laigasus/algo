package day09;

public class Bitwise3_1 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("result=" + setRightmostUnsetBit(n));
    }

    public static int setRightmostUnsetBit(int n) {
        if (n == 0)
            return 1;
        if ((n & (n + 1)) == 0)
            return n;
        int pos = getPosOfRightmostSetBit(n);
        return ((1 << pos) | n);
    }

    public static int getPosOfRightmostSetBit(int n) {
        return (int) (Math.log10(~n & (n + 1))/Math.log10(2));
    }
}
