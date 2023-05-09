import java.io.IOException;
import java.util.Scanner;

public class P2475 {

    public static void main(String[] args) throws IOException {
        // input
        Scanner sc = new Scanner(System.in);
        sc.close();

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int temp = sc.nextInt();
            sum += temp * temp;
        }

        int result = sum % 10;
        System.out.println(result);
    }
}