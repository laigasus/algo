
import java.util.Scanner;

class S2046 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            sb.append("#");
        }

        sc.close();
        System.out.println(sb);
    }
}