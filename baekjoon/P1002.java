import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            sb.append(calc(x1, y1, r1, x2, y2, r2)).append("\n");
        }

        System.out.print(sb);
    }

    static int calc(int x1, int y1, int r1, int x2, int y2, int r2) {

        int dist = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (x1 == x2 & y1 == y2 & r1 == r2) {
            // 중점, 반지름 모두 같음
            return -1;
        } else if (dist > Math.pow(r1 + r2, 2)) {
            // 두 반지름 합보다 중점 거리가 더 길때
            return 0;
        } else if (dist < Math.pow(r1 - r2, 2)) {
            // 원 안에 있음
            return 0;
        } else if (dist == Math.pow(r1 - r2, 2)) {
            // 내접
            return 1;
        } else if (dist == Math.pow(r1 + r2, 2)) {
            // 외접
            return 1;
        } else {
            // 그외
            return 2;
        }
    }
}