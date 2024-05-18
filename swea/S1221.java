import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class S1221 {
    static StringBuilder sb = new StringBuilder();

    static enum Number {
        ZRO, ONE, TWO, THR, FOR, FIV, SIX, SVN, EGT, NIN
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.next();

            int M = sc.nextInt();

            List<String> list = new ArrayList<>();

            while (M-- > 0) {
                list.add(sc.next());
            }

            Collections.sort(list, (String s1, String s2) -> {
                return Number.valueOf(s1).ordinal() - Number.valueOf(s2).ordinal();
            });

            sb.append("#" + test_case).append('\n');
            list.forEach(li -> sb.append(li).append(' '));
            sb.append('\n');
        }

        System.out.print(sb);
    }

}