import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class P17214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String polynomial = br.readLine();

        if (polynomial.charAt(0) == 'x' || ('1' < polynomial.charAt(0) && polynomial.charAt(0) <= '9')) {
            polynomial = "+" + polynomial;
        }

        List<String> str = new ArrayList<>(Arrays.stream(polynomial.split("[\\+\\-]")).collect(Collectors.toList()));
        if (str.get(0).equals("")) {
            str.remove(0);
        }
        Queue<Character> expr = new LinkedList<>();

        for (char c : polynomial.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                expr.add(c);
            }
        }

        for (String s : str) {
            int freq = Collections.frequency(Arrays.asList(s.split("")), "x");
            int n = Integer.parseInt(s.split("x")[0]);
            int pad = n / (freq + 1);
            if (pad == 0) {
                continue;
            }
            sb.append(expr.isEmpty() ? "" : expr.poll());
            sb.append(pad == 1 ? "" : pad);
            sb.append("x".repeat(freq + 1));
        }
        sb.append("+W");
        if (sb.charAt(0) == '+') {
            sb.replace(0, 1, "");
        }
        System.out.println(sb);
    }
}
