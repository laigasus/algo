import java.util.Scanner;

public class P2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();
        String str = new StringBuilder(Integer.toString(b)).reverse().toString();
        for (String s : str.split("")) {
            System.out.println(a * Integer.parseInt(s));
        }
        System.out.println(a * b);
        sc.close();
    }
}
