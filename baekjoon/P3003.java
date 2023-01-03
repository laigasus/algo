import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> now = new ArrayList<>();
        int[] standard = { 1, 1, 2, 2, 2, 8 };

        for (int i = 0; i < standard.length; i++)
            now.add(sc.nextInt());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < now.size(); i++) {
            list.add(standard[i] - now.get(i));
        }

        list.forEach(i -> System.out.print(i + " "));
        sc.close();
    }
}
