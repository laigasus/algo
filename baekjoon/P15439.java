import java.util.Scanner;

public class P15439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        System.out.println(N * (N - 1));
    }
}