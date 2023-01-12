import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < repeat; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            list.add(a + b);
        }
        sc.close();

        list.forEach(System.out::println);
    }
}
