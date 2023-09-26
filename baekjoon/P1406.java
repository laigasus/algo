import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Character> left = new ArrayDeque<>();
        ArrayDeque<Character> right = new ArrayDeque<>();

        for (char c : br.readLine().toCharArray()) {
            left.push(c);
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            String cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case 'P':
                    left.push(cmd.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!left.isEmpty()) {
            sb.append(left.pollLast());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
