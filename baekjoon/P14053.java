import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Solution2 {
	static int[][] board;
	static int N, M;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		board = new int[N][M];

		int y = sc.nextInt();
		int x = sc.nextInt();
		int dir = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		dfs(y, x, dir);

		sc.close();

		System.out.println(cnt);
	}

	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { -1, 0, 1, 0 };

	private static void dfs(int y, int x, int dir) {
		// 안닦여 있으면 cnt++
		if (board[y][x] == 0) {
			board[y][x] = 2;
			cnt++;
		}

		// 현재 board 상황
		// print(y, x, dir);

		// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
		int repeat = dx.length;
		while (repeat-- > 0) {
			dir = (dir + 3) % 4;

			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (!isInside(ny, nx)) {
				continue;
			}

			// 벽이거나 이미 닦은 곳
			if (board[ny][nx] >= 1) {
				continue;
			}

			// 현재 칸이 아직 청소되지 않은 경우, 현재 칸으로 이동
			if (board[ny][nx] == 0) {
				dfs(ny, nx, dir);
				return;
			}
		}

		// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
		int back = (dir + 2) % dx.length;
		int ny = y + dy[back];
		int nx = x + dx[back];

		if (isInside(ny, nx) && board[ny][nx] != 1) {
			dfs(ny, nx, dir);
		}
	}

	private static void print(int y, int x, int dir) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("로봇위치> y=%d, x=%d\n", y, x));
		sb.append(String.format("바라보는 방향> %d\n", dir));
		sb.append(String.format("닦은 타일 수> %d\n", cnt));

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(y == i && x == j ? "X" : board[i][j]).append(' ');
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}

	private static boolean isInside(int ny, int nx) {
		return ny >= 0 && nx >= 0 && ny < N && nx < M;
	}

}