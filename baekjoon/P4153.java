import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> n;

        while (true) {
            n = new ArrayList<>();
            for (String s : br.readLine().split(" ")) {
                n.add((int) Math.pow(Integer.parseInt(s), 2));
            }
            if (n.get(0) == 0)
                break;
            int max = Collections.max(n);
            n.remove(n.indexOf(max));
            if (n.get(0) + n.get(1) == max) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
