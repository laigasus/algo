package day07;

import java.util.*;
class Solution {
	int[] unf;
	public int Find(int v){
		return 0;
	}
	public void Union(int a, int b){
		
	}
	public String solution(int n, int[][] friend, int s1, int s2){
		unf = new int[n+1];
		for(int i = 1; i <= n; i++) unf[i] = i;
			
		return "";
	}
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(9, new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 5}, {6, 7}, {7, 8}, {8, 9}}, 3, 8));
	}
}