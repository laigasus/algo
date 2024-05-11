import java.util.Scanner;

class S1933 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int a= 1;
        int b= 2;
        Math.abs(a-b);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            if (T % i == 0) {
                sb.append(i).append(' ');
            }
        }

        System.out.println(sb);
    }
}