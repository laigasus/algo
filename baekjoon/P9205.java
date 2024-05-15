import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class P9205 {
    static boolean[] visited;
    static List<List<Point>> graph;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            graph = new ArrayList<>();

            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            Point start = new Point(0, sc.nextInt(), sc.nextInt());
            List<Point> points = new ArrayList<>();

            points.add(start);

            for (int i = 1; i <= n; i++) {
                points.add(new Point(i, sc.nextInt(), sc.nextInt()));
            }

            Point end = new Point(n + 1, sc.nextInt(), sc.nextInt());
            points.add(end);

            visited = new boolean[points.size()];

            for (int i = 0; i < points.size() - 1; i++) {
                for (int j = i + 1; j < points.size(); j++) {
                    Point a = points.get(i);
                    Point b = points.get(j);

                    if (Math.abs(a.x - b.x) + Math.abs(a.y - b.y) <= 1000) {
                        graph.get(a.idx).add(b);
                        graph.get(b.idx).add(a);
                    }
                }
            }

            boolean result = bfs(start, end);
            sb.append(result ? "happy" : "sad").append('\n');
        }

        sc.close();

        System.out.print(sb);
    }

    private static class Point {
        int idx, y, x;

        public Point(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point b) {
            return this.x == b.x && this.y == b.y;
        }
    }

    private static boolean bfs(Point start, Point end) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.idx] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (end.equals(now)) {
                return true;
            }

            for (Point next : graph.get(now.idx)) {
                if (!visited[next.idx]) {
                    visited[next.idx] = true;
                    q.offer(next);
                }
            }
        }

        return false;
    }

}