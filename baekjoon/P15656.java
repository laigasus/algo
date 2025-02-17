import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P15656 {

    private static final StringBuilder sb = new StringBuilder();
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        calc(new Stack<>(), M);

        System.out.print(sb);
    }

    private static void calc(Stack<Integer> stack, final int M) {
        if (stack.size() == M) {
            for (int s : stack) {
                sb.append(s).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int num : nums) {
            stack.add(num);
            calc(stack, M);
            stack.pop();
        }
    }
}
