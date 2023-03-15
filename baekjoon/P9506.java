import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> list;
        while (n != -1) {
            int sum = 0;
            list = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }
            sb.append(n);
            if (sum == n) {
                sb.append(" = ");
                for (int i = 0; i < list.size() - 1; i++) {
                    sb.append(list.get(i)).append(" + ");
                }
                sb.append(list.get(list.size() - 1));
            } else {
                sb.append(" is NOT perfect.");
            }
            sb.append("\n");
            n = Integer.parseInt(br.readLine());
        }

        System.out.print(sb);
    }
}