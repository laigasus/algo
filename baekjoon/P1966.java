import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<PrintInfo> arr;
        ArrayList<Integer> priority;

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new ArrayDeque<>(N);
            priority = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (j == M) {
                    arr.add(new PrintInfo(num, true));
                } else {
                    arr.add(new PrintInfo(num));
                }
                priority.add(num);
            }
            Collections.sort(priority);

            int cnt = 0;
            while (arr.size() > 0) {
                int printFirst = Collections.max(priority);
                PrintInfo pInfo = arr.pollFirst();
                if (pInfo.priority != printFirst) {
                    arr.addLast(pInfo);
                } else {
                    priority.remove(priority.indexOf(printFirst));
                    cnt++;
                    if (pInfo.selected) {
                        break;
                    }
                }

            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);

    }
}

class PrintInfo {
    int priority;
    boolean selected = false;

    public PrintInfo(int priority) {
        super();
        this.priority = priority;
    }

    public PrintInfo(int priority, boolean selected) {
        super();
        this.priority = priority;
        this.selected = selected;
    }
}
