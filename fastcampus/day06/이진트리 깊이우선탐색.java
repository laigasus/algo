package day06;

class Solution {
	public void DFS(int v) {
		if (v > 7)
			return;
		else {
			System.out.print(v + " ");
			DFS(v * 2);
			DFS(v * 2 + 1);
		}
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		T.DFS(1);
	}
}