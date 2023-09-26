package day06;

import java.util.Stack;

class Solution5 {
	Stack<Integer> pm = new Stack<>();
	static int[] ch;

	public void DFS(int n, int m) {
		if (pm.size() == m) {
			StringBuilder sb = new StringBuilder();
			for (int x : pm) {
				sb.append(x).append(' ');
			}

			System.out.println(sb);
		} else {
			for (int i = 1; i <= n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					pm.push(i);
					DFS(n, m);
					ch[i] = 0;
					pm.pop();
				}
			}
		}
	}

	public void solution(int n, int m) {
		ch = new int[n + 1];
		DFS(n, m);
	}

	public static void main(String[] args) {
		Solution5 T = new Solution5();
		T.solution(3, 2);
	}
}