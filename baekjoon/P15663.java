import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class P15663 {
    static int N, M;
    static int[] nums;
    static LinkedHashSet<String> cases = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        N = readInt();
        M = readInt();

        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = readInt();
        }
        Arrays.sort(nums);

        calc(new ArrayList<>(), new boolean[N]);

        cases.forEach(System.out::println);
    }

    private static void calc(List<Integer> list, boolean[] visited) {
        if (list.size() > M) {
            return;
        }

        if (list.size() == M) {
            StringBuilder tmp = new StringBuilder();

            for (int num : list) {
                tmp.append(num).append(' ');
            }

            cases.add(tmp.toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;

            calc(list, visited);

            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}
