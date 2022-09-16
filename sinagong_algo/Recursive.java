package sinagong_algo;

public class Recursive {
    static int result;

    public static void main(String[] args) {
        factorial(5);
    }

    static int factorial(int n) {
        if (n == 1) {
            result = 1;
            System.out.println(result);
            return result;
        }

        result = n * factorial(n - 1);
        System.out.println(result);
        return result;
    }
}
