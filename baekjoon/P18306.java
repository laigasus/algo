import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class P18306 {
    private static class Point {
        int x, y;
        double avgDistance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void calcAvgDistance(int N, Point... points) {
            int total = 0;
            for (var point : points) {
                total += Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
            }

            this.avgDistance = total * 1.0 / (N - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            points[i] = new Point(readInt(), readInt());
        }

        for (var point : points) {
            point.calcAvgDistance(N, points);
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.avgDistance == p2.avgDistance && p1.x == p2.x) {
                    return p1.y - p2.y;
                } else if (p1.avgDistance == p2.avgDistance) {
                    return p1.x - p2.x;
                } else {
                    return Double.compare(p1.avgDistance, p2.avgDistance);
                }
            }
        });

        var result = points[0];
        System.out.println(result.x + " " + result.y);

    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}
