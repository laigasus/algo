import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P11729 {
    static List<Stack<Integer>> list = new ArrayList<>(3);
    static StringBuilder sb = new StringBuilder();
    final static int towers = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < towers + 1; i++) {
            list.add(new Stack<>());
        }

        for (int i = N; i > 0; i--) {
            list.get(1).push(i);
        }
        sb.append((int) Math.pow(2, N) - 1).append("\n");
        move(N, 1, 2, 3);
        System.out.print(sb);
    }

    static void move(int N, int a, int b, int c) {
        if (N > 0) {
            move(N - 1, a, c, b);
            list.get(c).push(list.get(a).pop());
            sb.append(a + " " + c + "\n");
            move(N - 1, b, a, c);
        }
    }
}
