
import java.util.Scanner;

class S2043 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int key = sc.nextInt();
        int num = sc.nextInt();

        for (int cnt = 1; cnt <= 1000; cnt++) {
            if (key == num) {
                sb.append(cnt);
                break;
            }
            num = (num + 1) % 1000;
        }

        sc.close();
        System.out.println(sb.isEmpty() ? -1 : sb);
    }
}