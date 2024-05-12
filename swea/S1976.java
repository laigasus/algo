
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class S1976 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            DateTimeFormatter form = DateTimeFormatter.ofPattern("h m");
            LocalTime time = LocalTime.of(h, m, 0);

            h = sc.nextInt();
            m = sc.nextInt();

            time = time.plusHours(h);
            time = time.plusMinutes(m);

            sb.append(String.format("#%d %s\n", test_case, time.format(form)));
        }

        System.out.println(sb);
    }
}