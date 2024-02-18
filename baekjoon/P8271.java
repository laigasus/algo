import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P8271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isPlaced = new boolean[n];

        Map<Integer, Integer> rooks = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = str.charAt(j);
                if (c == 'W') {
                    isPlaced[j] = true;
                    rooks.put(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!rooks.containsKey(i)) {
                for (int j = 0; j < n; j++) {
                    if (!isPlaced[j]) {
                        isPlaced[j] = true;
                        rooks.put(i, j);
                        break;
                    }
                }
            }
        }

        String[] board = new String[n];

        for (int i = 0; i < n; i++) {
            char[] row = ".".repeat(n).toCharArray();
            if (rooks.containsKey(i)) {
                row[rooks.get(i)] = 'W';
            }
            board[i] = new String(row);
        }

        System.out.print(String.join("\n", board));
    }
}
