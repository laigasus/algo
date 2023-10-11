package day07;

import java.util.ArrayList;

class Solution3 {
	ArrayList<ArrayList<Integer>> graph;
	boolean[] visited;
	int cnt;

	public void DFS(int now) {
		visited[now] = true;
		cnt++;

		for (var next : graph.get(now)) {
			if (!visited[next]) {
				DFS(next);
			}
		}
	}

	public int solution(int N, int[][] edge) {
		graph = new ArrayList<>();
		visited = new boolean[N + 1];
		cnt = 0;

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] e : edge) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		DFS(1);

		return N - cnt;
	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();
		System.out.println(T.solution(11, new int[][] { { 1, 2 }, { 1, 4 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 },
				{ 7, 10 }, { 8, 9 }, { 10, 11 } }));
		System.out
				.println(T.solution(12, new int[][] { { 1, 2 }, { 1, 7 }, { 1, 8 }, { 1, 6 }, { 8, 11 }, { 11, 12 } }));
		System.out.println(
				T.solution(14, new int[][] { { 1, 6 }, { 1, 5 }, { 6, 7 }, { 7, 8 }, { 9, 8 }, { 3, 4 }, { 4, 14 } }));
		System.out.println(T.solution(15, new int[][] { { 1, 4 }, { 1, 5 }, { 9, 5 }, { 9, 6 }, { 7, 9 }, { 7, 14 } }));
	}
}