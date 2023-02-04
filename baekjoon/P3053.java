import java.util.Scanner;

public class P3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double R = sc.nextDouble();
        sc.close();

        System.out.printf("%.6f\n", Math.PI * R * R);
        System.out.printf("%.6f\n", 2 * R * R);
    }
}
