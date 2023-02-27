import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            boolean isUnderflow = false;
            String[] str = br.readLine().split("");
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            for (String s : str) {
                if (s.equals("(")) {
                    stack.push(num++);
                } else {
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        sb.append("NO").append("\n");
                        isUnderflow = true;
                        break;
                    }
                }
            }
            if (isUnderflow) {
                continue;
            }

            if (stack.empty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
