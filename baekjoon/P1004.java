import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            int cnt = 0;
            Circle circle;
            int[] coord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = coord[0], y1 = coord[1], x2 = coord[2], y2 = coord[3];

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                int[] c = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int cx = c[0], cy = c[1], r = c[2];

                circle = new Circle(cx, cy, r);
                if (circle.needPassOrbit(x1, y1, x2, y2)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
            T--;
        }
        br.close();

        System.out.print(sb);
    }
}

class Circle {
    int cx;
    int cy;
    int r;

    public Circle(int cx, int cy, int r) {
        super();
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    boolean needPassOrbit(int x1, int y1, int x2, int y2) {
        // 출발점이 원 안에 있고, 목적지가 원 밖에 있으면 이탈 +1
        // 출발점이 원 밖에 있고, 목적지가 원 안에 있으면 진입 +1
        // 출발점과 목적지가 원 안에 있으면 변동 X
        // 출발점과 목적지가 원 밖에 있으면 변동 X
        // (시작점-소행성 좌표)^2 > 소행성 반지름^2 && (종착점-소행성좌표)^2>소행성 반지름^2
        double r1 = Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2);
        double r2 = Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2);

        if (r1 > r * r && r2 > r * r) {
            return false;
        } else if (r1 < r * r && r2 < r * r) {
            return false;
        } else {
            return true;
        }
    }
}