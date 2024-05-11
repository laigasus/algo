
import java.util.Scanner;

class S1936 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        switch (Math.abs(a - b)) {
            case 1:
                sb.append(a > b ? 'A' : 'B');
                break;
            case 2:
                sb.append(a > b ? 'B' : 'A');
                break;
            default:
                throw new IllegalArgumentException("유효 값이 아닙니다.");
        }

        System.out.println(sb);
    }
}