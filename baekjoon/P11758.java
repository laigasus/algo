import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11758 {
    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point p2 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int A = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y;
        int B = p1.y * p2.x + p2.y * p3.x + p3.y * p1.x;
        int lean = A - B;

        // 시계(볼록), 반시계(오목), 평행
        System.out.println(lean > 0 ? "1" : (lean < 0 ? "-1" : "0"));
    }
}