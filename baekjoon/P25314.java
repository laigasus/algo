import java.util.Scanner;

public class P25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append("long ".repeat(N / 4)).append("int");

        System.out.println(sb);
        sc.close();
    }
}
