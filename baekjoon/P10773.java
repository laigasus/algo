import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        while (K > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n > 0) {
                stack.push(n);
            } else {
                stack.pop();
            }
            K--;
        }

        System.out.println(stack.parallelStream().mapToInt(i -> i).sum());
        br.close();
    }
}
