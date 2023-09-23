package day05;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
	static final int[] moves = { -1, 1, 5 };
	static final int MAX_COORDINATE = 10_000;
	static boolean[] visited;

	class Point {
		int pos, cnt;

		public Point(int pos, int cnt) {
			this.pos = pos;
			this.cnt = cnt;
		}
	}

	public int solution(int home) {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[MAX_COORDINATE + 1];
		queue.offer(new Point(0, 0));
		visited[0] = true;
		int answer = Integer.MAX_VALUE;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int move : moves) {
				int next = now.pos + move;

				if (next < 0 || next > MAX_COORDINATE) {
					continue;
				}

				if (visited[next]) {
					continue;
				}

				if (next != home) {
					visited[next] = true;
					queue.offer(new Point(next, now.cnt + 1));
				} else {
					answer = Math.min(answer, now.cnt + 1);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		System.out.println(T.solution(10));
		System.out.println(T.solution(14));
		System.out.println(T.solution(25));
		System.out.println(T.solution(24));
		System.out.println(T.solution(345));
	}
}