package day02;

import java.util.Arrays;

class Solution5 {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	private class Robot {
		int r, c;

		Robot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int[] solution(int[][] board, int k) {
		int len = board.length;
		Robot robot = new Robot(0, 0);

		int d = 1;
		while (k-- > 0) {
			int nr = robot.r + dr[d];
			int nc = robot.c + dc[d];

			if (nr < 0 || nc < 0 || nr >= len || nc >= len || board[nr][nc] == 1) {
				d = (d + 1) % 4;
			} else {
				robot.r = nr;
				robot.c = nc;
			}
		}
		return new int[] { robot.r, robot.c };
	}

	public static void main(String[] args) {
		Solution5 T = new Solution5();

		System.out.println(Arrays.toString(T.solution(new int[][] {
				{ 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0 } }, 10)));

		System.out.println(Arrays.toString(T.solution(new int[][] {
				{ 0, 0, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0 } }, 20)));

		System.out.println(Arrays.toString(T.solution(new int[][] {
				{ 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } }, 25)));
	}
}