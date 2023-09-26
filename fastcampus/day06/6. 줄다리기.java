package day06;

import java.util.Stack;

class Solution6 {
	private static final int SIZE = 7;

	int answer;
	int[][] hates = new int[SIZE + 1][SIZE + 1];
	Stack<Integer> st;
	boolean[] visited;

	public void DFS() {
		if (st.size() == SIZE) {
			answer++;
			return;
		}

		for (int i = 1; i <= SIZE; i++) {
			if (visited[i]) {
				continue;
			}
			if (!st.isEmpty() && hates[st.peek()][i] == 1) {
				continue;
			}

			st.push(i);
			visited[i] = true;
			DFS();
			st.pop();
			visited[i] = false;
		}
	}

	public int solution(int[][] fight) {
		answer = 0;
		hates = new int[SIZE + 1][SIZE + 1];
		st = new Stack<>();
		visited = new boolean[SIZE + 1];

		for (var x : fight) {
			hates[x[0]][x[1]] = 1;
			hates[x[1]][x[0]] = 1;
		}

		DFS();
		return answer;
	}

	public static void main(String[] args) {
		Solution6 T = new Solution6();
		System.out.println(T.solution(new int[][] { { 1, 3 }, { 5, 7 }, { 4, 2 } }));
		System.out.println(T.solution(new int[][] { { 3, 2 }, { 3, 5 }, { 5, 2 }, { 7, 3 } }));
		System.out.println(T.solution(new int[][] { { 1, 2 }, { 1, 5 }, { 1, 7 }, { 1, 3 } }));
		System.out.println(T.solution(new int[][] { { 1, 7 } }));
		System.out.println(T.solution(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }));
	}
}
