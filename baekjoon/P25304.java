import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalPrice = sc.nextInt();
        int repeat = sc.nextInt();

        List<Integer> receipt = new ArrayList<>();
        for (int i = 0; i < repeat; i++) {
            receipt.add(sc.nextInt() * sc.nextInt());
        }
        System.out.println(receipt.stream().mapToInt(i -> i).sum() == totalPrice ? "Yes" : "No");
        sc.close();
    }
}
