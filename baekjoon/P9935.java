import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        String regex = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            if (stack.size() >= regex.length()) {
                if (isBomb(stack, regex)) {
                    for (int k = 0; k < regex.length(); k++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.size() > 0) {
            stack.forEach(c -> sb.append(c));
        } else {
            sb.append("FRULA");
        }
        System.out.println(sb);
    }

    static boolean isBomb(Stack<Character> stack, String regex) {
        for (int j = 0; j < regex.length(); j++) {
            if (stack.get(stack.size() - regex.length() + j) != regex.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
