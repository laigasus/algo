import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class P12101 {
    final static int NONE = -1;
    final static int[] MAGIC_NUMS = { 1, 2, 3 };

    static List<String> cases;
    static List<Integer> list;
    static int N;

    static {
        cases = new ArrayList<>();
        list = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());// 자연수 번째

        calc(0);

        Collections.sort(cases);

        System.out.println(K > cases.size() ? NONE : cases.get(K - 1));
    }

    static void calc(int sum) {
        if (sum > N) {
            return;
        }

        if (sum == N) {
            StringJoiner sj = new StringJoiner("+");
            for (var v : list) {
                sj.add(Integer.toString(v));
            }

            cases.add(sj.toString());
            return;
        }

        for (int num : MAGIC_NUMS) {
            list.add(num);
            calc(sum + num);
            list.remove(list.size() - 1);
        }
    }
}
