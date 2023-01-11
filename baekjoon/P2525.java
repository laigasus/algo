import java.util.Scanner;

public class P2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), m = sc.nextInt(), bake = sc.nextInt();

        // 하루는 24시 x 60분 = 1440분 이다.
        int sum = (60 * h + m + bake) % 1440;
        h = sum / 60;
        m = sum % 60;

        System.out.printf("%d %d\n", h, m);
        sc.close();
    }
}
