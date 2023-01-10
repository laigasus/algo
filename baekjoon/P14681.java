import java.util.Scanner;

public class P14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        System.out.println(x * y > 0 ? (x > 0 ? "1" : "3") : (x > 0 && y < 0 ? "4" : "2"));
        sc.close();
    }
}
