import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P18258 {
    static LinkedList<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            task(br.readLine());
        }

        System.out.print(sb);
    }

    static void task(String cmd) {
        int rs = 0;
        st = new StringTokenizer(cmd);

        switch (st.nextToken()) {
            case "push":
                queue.add(Integer.parseInt(st.nextToken()));
                return;

            case "pop":
                try {
                    rs = queue.poll();
                } catch (Exception e) {
                    rs = -1;
                }
                break;

            case "size":
                rs = queue.size();
                break;

            case "empty":
                rs = queue.isEmpty() ? 1 : 0;
                break;

            case "front":
                try {
                    rs = queue.peek();
                } catch (Exception e) {
                    rs = -1;
                }
                break;

            case "back":
                try {
                    rs = queue.get(queue.size() - 1);
                } catch (Exception e) {
                    rs = -1;
                }
                break;
        }
        sb.append(rs).append("\n");
    }
}
