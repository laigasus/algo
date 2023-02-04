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
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int rs;
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            double r3 = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
            if (x1 == x2 & y1 == y2 & r1 == r2) {
                // 중점, 반지름 모두 같음
                rs = -1;
            } else if (r3 > Math.pow(r1 + r2, 2)) {
                // 두 반지름 합보다 중점 거리가 더 길때
                rs = 0;
            } else if (r3 < Math.pow(r1 - r2, 2)) {
                // 원 안에 있음
                rs = 0;
            } else if (r3 == Math.pow(r1 - r2, 2)) {
                // 내접
                rs = 1;
            } else if (r3 == Math.pow(r1 + r2, 2)) {
                // 외접
                rs = 1;
            } else {
                // 그외
                rs = 2;
            }
            sb.append(rs).append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}
