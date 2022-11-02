package day08.ch7;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class MazeEscape {
    static int[][] graph = { { 1, 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1 } };
    static Queue<Node> q = new LinkedList<>();
    static int N = graph.length;
    static int M = graph[0].length;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static int bfs(int x, int y) {
        q.add(new Node(x, y));
        
        while (!q.isEmpty()) {
            Node node = q.remove();
            x = node.x;
            y = node.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && graph[ny][nx] == 1) {
                    graph[ny][nx] = graph[y][x] + 1;
                    q.add(new Node(nx, ny));
                }
            }
        }

        return graph[N - 1][M - 1];
    }

    public static void main(String[] args) {
        System.out.println("최단거리>" + bfs(0, 0));
    }
}
