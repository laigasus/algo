import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        int num = 1;
        do {
            if (num <= list.get(idx)) {
                sb.append("+").append("\n");
                stack.push(num++);
            } else {
                if (stack.peek() == list.get(idx)) {
                    sb.append("-").append("\n");
                    stack.pop();
                    idx++;
                } else {
                    sb = new StringBuilder();
                    sb.append("NO").append("\n");
                    break;
                }
            }
        } while (idx < n);

        System.out.print(sb);
        br.close();
    }
}
