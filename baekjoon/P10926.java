import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P10926 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("joonas", "baekjoon");
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int idx = list.indexOf(input);
        System.out.println(idx != -1 ? list.get(idx) + "??!" : input);
        sc.close();
    }
}
