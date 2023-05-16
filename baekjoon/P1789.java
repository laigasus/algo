import java.util.Scanner;

public class P1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        sc.close();

        long sum = 0;
        int cnt = 0;
        for (int i = 1;; i++) {
            if (sum > num) {
                break;
            }

            sum += i;
            cnt++;
        }
        System.out.println(cnt - 1);
    }
}