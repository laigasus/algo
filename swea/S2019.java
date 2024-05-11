
import java.util.Scanner;

class S2019 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= T; i++) {
            sb.append(1 << i).append(' ');
        }

        System.out.println(sb);
    }
}