package day07;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public void solution(int n, int[][] edge) {
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] e : edge) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

	}

	public static void main(String[] args) {
		Solution T = new Solution();
		T.solution(5, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 } });
	}
}