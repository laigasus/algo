import java.util.Scanner;

public class P1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int x = 0, y = 0;
        boolean reverse = true;
        for (x = 1, y = 1; n - 1 > 0; n--) {
            if (reverse) {
                y--;
                x++;
            } else {
                y++;
                x--;
            }
            if (y == 0) {
                reverse = false;
                y++;
            }
            if (x == 0) {
                reverse = true;
                x++;
            }
        }
        System.out.println(y + "/" + x);
    }
}
