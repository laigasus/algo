package day06;

import java.util.Arrays;

class Solution {
	int[] dr = { -1, 0, 1, 0 };
	int[] dc = { 0, 1, 0, -1 };

	public void DFS(int r, int c, int[][] board) {

	}

	public int[] solution(int[][] board) {
		return null;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[][] { { 0, 1, 1, 0, 0 }, { 0, 1, 1, 0, 0 },
				{ 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 1, 1, 0 } })));
		System.out.println(Arrays.toString(T.solution(new int[][] { { 1, 1, 1, 0, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 1, 0, 0 }, { 1, 1, 0, 1, 0 }, { 1, 0, 1, 0, 0 } })));
		System.out.println(Arrays.toString(T.solution(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 1, 0, 0 },
				{ 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0 }, { 0, 0, 1, 1, 0 } })));
		System.out.println(Arrays.toString(T.solution(new int[][] { { 0, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0 } })));
	}
}
