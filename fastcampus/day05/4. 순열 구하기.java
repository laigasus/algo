package day05;

import java.util.*;
class Solution{
	Stack<Integer> pm = new Stack<>();
	public void DFS(int L, int n, int m, int[] ch){
		
	}
	public void solution(int n, int m){
		int[] ch = new int[n+1];
		DFS(0, n, m, ch);
	}
	public static void main(String[] args){
		Solution T = new Solution();
		T.solution(3, 2);
	}
}