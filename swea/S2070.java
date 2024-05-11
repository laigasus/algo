import java.util.Scanner;

class S2070 {
    public static void main(String args[]) throws Exception {

        // System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            sb.append("#").append(test_case).append(" ");
            switch (Integer.signum(a - b)) {
                case 1:
                    sb.append(">");
                    break;
                case 0:
                    sb.append("=");
                    break;
                case -1:
                    sb.append("<");
                    break;
            }
            sb.append("\n");
        }

        sc.close();
        System.out.println(sb);
    }
}