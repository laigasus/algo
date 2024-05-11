import java.util.Scanner;

class S2072 {
    public static void main(String args[]) throws Exception {

        // System.setIn(new FileInputStream("res/input.txt"));
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                if (num % 2 == 0) {
                    continue;
                }
                sum += num;
            }

            sb.append(String.format("#%d %d\n", test_case, sum));
        }

        sc.close();
        System.out.println(sb);
    }
}