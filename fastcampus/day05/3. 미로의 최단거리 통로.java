package day05;

import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
	private static final int MAP_SIZE = 7;
	private static final int[] dy = { -1, 0, 1, 0 };
	private static final int[] dx = { 0, 1, 0, -1 };

	class Point {
		int y, x, cnt;

		public Point(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	public int solution(int[][] board) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[MAP_SIZE][MAP_SIZE];

		queue.offer(new Point(0, 0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			if (now.x == MAP_SIZE - 1 && now.y == MAP_SIZE - 1) {
				return now.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];

				if (nx < 0 || ny < 0 || nx >= MAP_SIZE || ny >= MAP_SIZE) {
					continue;
				}

				if (visited[ny][nx]) {
					continue;
				}

				if (board[ny][nx] == 1) {
					continue;
				}

				visited[ny][nx] = true;
				queue.offer(new Point(ny, nx, now.cnt + 1));
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();

		System.out.println(T.solution(new int[][] {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 0, 1, 1 },
				{ 1, 1, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 1, 0, 0 },
				{ 1, 0, 1, 0, 0, 0, 0 }
		}));

		System.out.println(T.solution(new int[][] {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 1, 0, 0 },
				{ 1, 0, 1, 0, 1, 0, 0 }
		}));

		System.out.println(T.solution(new int[][] {
				{ 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 1, 0, 1, 1 },
				{ 1, 1, 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 0, 1, 0, 0 },
				{ 1, 0, 1, 0, 0, 0, 0 }
		}));
	}
}