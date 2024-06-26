import java.util.Scanner;

class S2071 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += sc.nextInt();
            }

            sb.append(String.format("#%d %d\n", test_case, Math.round(sum / 10.0)));
        }

        sc.close();

        System.out.println(sb);
    }

}
