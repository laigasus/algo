package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 가중치에 음수가 있으면 벨만 포드를 사용함. 그게 아니면 다익스트라
class Edge implements Comparable<Edge> {
	public int v;
	public int cost;

	Edge(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge ob) {
		return this.cost - ob.cost;
	}
}

class Solution5 {
	ArrayList<ArrayList<Edge>> graph;
	int[] dist;

	public int solution(int N, int[][] edges, int end) {
		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int[] x : edges) {
			graph.get(x[0]).add(new Edge(x[1], x[2]));
		}

		return BFS(1, end);
	}

	private int BFS(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge now = pq.poll();

			if (now.cost > dist[now.v]) {
				continue;
			}

			for (Edge next : graph.get(now.v)) {
				if (dist[next.v] > now.cost + next.cost) {
					dist[next.v] = now.cost + next.cost;
					pq.offer(new Edge(next.v, dist[next.v]));
				}
			}

		}

		return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
	}

	public static void main(String[] args) {
		Solution5 T = new Solution5();
		System.out.println(T.solution(6, new int[][] {
				{ 1, 2, 12 }, { 1, 3, 4 }, { 2, 1, 2 },
				{ 2, 3, 5 }, { 2, 5, 5 }, { 3, 4, 5 },
				{ 4, 2, 2 }, { 4, 5, 5 }, { 6, 4, 5 } }, 5));
	}
}