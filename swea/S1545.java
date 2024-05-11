
import java.util.Scanner;

class S1545 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = T; i >= 0; i--) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}