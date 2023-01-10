import java.util.Scanner;

public class P9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = "";
        switch (n / 10) {
            case 10:
                str = "A";
                break;
            case 9:
                str = "A";
                break;
            case 8:
                str = "B";
                break;
            case 7:
                str = "C";
                break;
            case 6:
                str = "D";
                break;
            default:
                str = "F";
                break;
        }
        System.out.println(str);
        sc.close();
    }
}
