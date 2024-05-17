import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class S4615 {
	static final int B = 1, W = 2;
	static StringBuilder sb = new StringBuilder();
	static int[][] board;
	static int N, M;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		// N극 1, S극 2
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			initPlace(N);

			while (M-- > 0) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int color = sc.nextInt();

				place(y, x, color);
				// print(M, y, x, color);
			}

			Map<Integer, Integer> result = count();
			int black = result.get(1);
			int white = result.get(2);

			sb.append(String.format("#%d %d %d\n", test_case, black, white));
		}

		System.out.println(sb);
	}

	private static void print(int m, int y, int x, int color) {
		System.out.println("남은 횟수>" + m);
		System.out.println("착수>" + (color == 1 ? "B" : "W"));
		System.out.println("위치>" + "y=" + y + ", x=" + x);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == y && j == x) {
					sb.append("X");
				} else {
					sb.append(board[i][j]);
				}
				sb.append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}

	private static Map<Integer, Integer> count() {
		Map<Integer, Integer> result = new HashMap<>();
		result.put(0, 0);
		result.put(1, 0);
		result.put(2, 0);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				result.put(board[i][j], result.get(board[i][j]) + 1);
			}
		}

		return result;
	}

	// w b b w 0 ?
	private static void initPlace(int N) {
		board = new int[N][N];

		// 백돌(2) 착수
		board[N / 2 - 1][N / 2 - 1] = 2;
		board[N / 2][N / 2] = 2;

		// 흑돌(1) 착수
		board[N / 2 - 1][N / 2] = 1;
		board[N / 2][N / 2 - 1] = 1;
	}

	// 시계 방향 탐색
	static final int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static final int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	private static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	// 착수. 돌을 두면 수직, 수평, 좌우대각의 끝을 확인하여 같은 색이면 안의 모든 값을 해당 색으로 교체
	private static void place(int y, int x, int color) {
		board[y][x] = color;

		for (int i = 0; i < dx.length; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (!isInside(ny, nx)) {
				continue;
			}

			if (board[ny][nx] == 0) {
				continue;
			}

			if (board[ny][nx] != color) {
				List<Point> points = getNearbyPoints(color, i, ny, nx);

				Point end = points.get(points.size() - 1);
				if (board[end.y][end.x] == color) {
					// 범위 내 착수한 색으로 변경
					points.forEach(p -> board[p.y][p.x] = color);
				}
			}
		}
	}

	private static List<Point> getNearbyPoints(int color, int i, int ny, int nx) {
		List<Point> points = new ArrayList<>();

		while (true) {
			if (!isInside(ny, nx)) {
				break;
			}

			if (board[ny][nx] == 0) {
				break;
			}

			if (board[ny][nx] == color) {
				points.add(new Point(ny, nx));
				break;
			} else {
				points.add(new Point(ny, nx));
				ny += dy[i];
				nx += dx[i];
			}
		}
		return points;
	}

	private static boolean isInside(int ny, int nx) {
		return ny >= 0 && nx >= 0 && ny < N && nx < N;
	}

}