import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class P2178_2 {
	static StringBuilder sb = new StringBuilder();
	static int[][] board;
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();// 세로
		M = sc.nextInt();// 가로

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		visited = new boolean[N][M];
		sb.append(bfs(new Point(0, 0, 1)));
		System.out.println(sb);
	}

	private static class Point {
		int x, y, depth;

		public Point(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	static final int[] dx = { -1, 0, 1, 0 };
	static final int[] dy = { 0, -1, 0, 1 };

	private static int bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		int depth = start.depth;

		q.offer(start);
		visited[start.y][start.x] = true;

		while (!q.isEmpty()) {
			Point now = q.poll();

			if (now.y == (N - 1) && now.x == (M - 1)) {
				depth = now.depth;
				break;
			}

			for (int i = 0; i < dx.length; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (!isBoundary(nx, ny)) {
					continue;
				}

				if (board[ny][nx] == 0) {
					continue;
				}

				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					Point next = new Point(nx, ny, now.depth + 1);
					q.offer(next);
				}
			}
		}

		return depth;
	}

	private static boolean isBoundary(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < M && ny < N;
	}

}