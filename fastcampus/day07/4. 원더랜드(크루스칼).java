package day07;

import java.util.*;
class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
	this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost - ob.cost;
    }
}

class Solution {
	int[] unf;
	public int Find(int v){
		if(v == unf[v]) return v;
		else return unf[v] = Find(unf[v]);
	}
	public void Union(int a, int b){
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) unf[fa] = fb;
	}
	public int solution(int n, int[][] edges){
		ArrayList<Edge> Eg = new ArrayList<>();
		unf = new int[n+1];
		for(int i = 1; i <= n; i++) unf[i] = i;

		return 0;
	}
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(9, new int[][]{{1, 2, 12}, {1, 9, 25}, {2, 3, 10}, {2, 8, 17}, {2, 9, 8}, {3, 4, 18}, {3, 7, 55}, {4, 5, 44}, {5, 6, 60}, {5, 7, 38}, {7, 8, 35}, {8, 9, 15}}));
	}
}