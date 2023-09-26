package day06;

import java.util.Stack;

class Solution4 {
	Stack<Integer> pm = new Stack<>();

	public void DFS(int N, int M) {
		if (pm.size() == M) {
			StringBuilder sb = new StringBuilder();
			for (int num : pm) {
				sb.append(num).append(' ');
			}
			System.out.println(sb);
			return;
		}

		for (int i = 1; i <= N; i++) {
			pm.push(i);
			DFS(i, M);
			pm.pop();
		}
	}

	public void solution(int N, int M) {
		DFS(N, M);
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
		T.solution(3, 2);
	}
}