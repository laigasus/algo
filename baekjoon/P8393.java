import java.util.Scanner;

public class P8393 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        // n = IntStream.rangeClosed(1, n).boxed().mapToInt(i -> i).sum();
        // System.out.println(n);
        System.out.println(n * (n + 1) / 2);
    }
}
