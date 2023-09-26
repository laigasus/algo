package day06;

class Solution {
	final int SIZE = 5;

	final int[] dr = { -1, 0, 1, 0 };
	final int[] dc = { 0, 1, 0, -1 };

	boolean[][] visited;

	public void DFS(int r, int c, int[][] board) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= SIZE || nc >= SIZE) {
				continue;
			}

			if (visited[nr][nc]) {
				continue;
			}

			if (board[nr][nc] == 1) {
				DFS(nr, nc, board);
			}

		}
	}

	public int solution(int[][] board) {
		int answer = 0;
		visited = new boolean[SIZE][SIZE];

		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (board[r][c] == 0) {
					continue;
				}
				if (!visited[r][c]) {
					DFS(r, c, board);
					answer++;
				}

			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[][] { { 0, 1, 1, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0 }, { 0, 0, 1, 1, 0 } }));
		System.out.println(T.solution(new int[][] { { 1, 1, 1, 0, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 1, 0, 0 },
				{ 1, 1, 0, 1, 0 }, { 1, 0, 1, 0, 0 } }));
		System.out.println(T.solution(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 0 }, { 0, 0, 1, 1, 0 } }));
		System.out.println(T.solution(new int[][] { { 0, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0 } }));
	}
}