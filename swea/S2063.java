import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class S2063 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int test_case = 1; test_case <= T; test_case++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int mid = T / 2;

        sc.close();
        System.out.println(list.get(mid));
    }
}