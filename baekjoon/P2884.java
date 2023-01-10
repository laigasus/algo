import java.util.Scanner;

public class P2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt(), m = sc.nextInt();
        h = m < 45 ? (--h < 0 ? 23 : h) : h;
        m = m < 45 ? m + 60 - 45 : m - 45;
        System.out.printf("%d %d\n", h, m);
        sc.close();
    }
}
