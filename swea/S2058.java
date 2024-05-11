
import java.util.Scanner;

class S2058 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int sum = 0;
        for (char c : String.valueOf(T).toCharArray()) {
            sum += (c - '0');
        }

        sc.close();
        System.out.println(sum);
    }
}