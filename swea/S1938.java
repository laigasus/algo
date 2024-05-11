
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append(a + b).append('\n');
        sb.append(a - b).append('\n');
        sb.append(a * b).append('\n');
        sb.append(a / b).append('\n');

        sc.close();
        System.out.println(sb);
    }
}