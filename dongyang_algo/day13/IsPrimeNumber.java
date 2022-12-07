package day13;

import java.math.BigInteger;

public class IsPrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrimeNumber(4));
        System.out.println(isPrimeNumber(7));
    }
    public static boolean isPrimeNumber(int number) {
        BigInteger bigInt = BigInteger.valueOf(number);
        return bigInt.isProbablePrime(10);
    }
}
