import java.util.Scanner;

public class P13909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int cnt = 0;
        for (int i = 1; i * i <= N; i++) {
            cnt++;
        }

        System.out.println(cnt);
    }
}
