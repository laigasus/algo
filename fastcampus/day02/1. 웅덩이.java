package day02;

class Solution {
	static final int AREA_SIZE = 5;
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public int solution(int[][] area) {
		int cnt = 0;
		for (int r = 0; r < AREA_SIZE; r++) {
			for (int c = 0; c < AREA_SIZE; c++) {
				boolean isPound = true;
				for (int i = 0; i < dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nc < 0 || nr >= AREA_SIZE || nc >= AREA_SIZE) {
						continue;
					}

					if (area[r][c] >= area[nr][nc]) {
						isPound = false;
						break;
					}
				}

				if (isPound) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[][] { { 10, 20, 50, 30, 20 }, { 20, 30, 50, 70, 90 },
				{ 10, 15, 25, 80, 35 }, { 25, 35, 40, 55, 80 }, { 30, 20, 35, 40, 90 } }));
		System.out.println(T.solution(new int[][] { { 80, 25, 10, 65, 100 }, { 20, 10, 32, 70, 33 },
				{ 45, 10, 88, 9, 90 }, { 10, 35, 10, 55, 66 }, { 10, 84, 65, 88, 99 } }));
		System.out.println(T.solution(new int[][] { { 33, 22, 55, 65, 55 }, { 55, 88, 99, 12, 19 },
				{ 18, 33, 25, 57, 77 }, { 46, 78, 54, 55, 99 }, { 33, 25, 47, 85, 17 } }));
	}
}