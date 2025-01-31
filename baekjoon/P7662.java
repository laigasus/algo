import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class P7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);

                switch (cmd) {
                    case 'I':
                        int v = Integer.parseInt(st.nextToken());
                        map.put(v, map.getOrDefault(v, 0) + 1);
                        break;

                    case 'D':
                        if (map.isEmpty()) {
                            break;
                        }

                        int key = Integer.parseInt(st.nextToken()) == -1 ? map.firstKey() : map.lastKey();
                        int count = map.get(key);

                        if (count == 1) {
                            map.remove(key);
                        } else {
                            map.put(key, count - 1);
                        }
                        break;

                    default:
                        throw new IOException("Wrong command");
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.print(sb);
    }
}