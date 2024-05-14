import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution2 {
    static StringBuilder sb = new StringBuilder();
    static int size = 100_000;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        size = Math.min(size, Math.max(N, K) * 2);

        System.out.println(bfs(N, K));
    }

    private static class Point {
        int x, time;

        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    private static int bfs(int start, int K) {
        Queue<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[size + 1];
        q.offer(new Point(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == K) {
                return now.time;
            }

            for (int x : new int[] { now.x * 2, now.x + 1, now.x - 1 }) {
                if (!isBoundary(x)) {
                    continue;
                }

                if (!visited[x]) {
                    Point next = new Point(x, now.time + 1);
                    visited[next.x] = true;
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    private static boolean isBoundary(int x) {
        return x >= 0 && x <= size;
    }

}