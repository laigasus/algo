import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P1463_2 {
    static final int END = 1;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        System.out.println(bfs(n));
    }

    private static class Point {
        int v, w;

        public Point(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static int bfs(int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(n, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.v == END) {
                return now.w;
            }

            if (now.v < END) {
                continue;
            }

            if (dist[now.v] > now.w) {
                dist[now.v] = now.w;

                if (now.v % 3 == 0) {
                    q.offer(new Point(now.v / 3, now.w + 1));
                }

                if (now.v % 2 == 0) {
                    q.offer(new Point(now.v / 2, now.w + 1));
                }

                q.offer(new Point(now.v - 1, now.w + 1));
            }
        }

        // 도달할 수 없음
        return -1;
    }

}