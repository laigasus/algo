package day08.ch6;

import java.util.Stack;

// 시간복잡도>인접리스트 O(정점 + 간선), 인접행렬 O(정점^2) 
public class DFS {
    static int[][] graph = { {}, { 2, 3, 8 }, { 1, 7 }, { 1, 4, 5 }, { 3, 5 }, { 3, 4 }, { 7 }, { 2, 6, 8 }, { 1, 7 } };
    static boolean[] visited = new boolean[9];
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        dfs(1);
    }

    public static void dfs(int x) {
        Stack<Integer> stack = new Stack<>();
        stack.push(x);
        visited[x] = true;

        while(!stack.empty()){
            int nodeIdx= stack.pop();
            System.out.print(nodeIdx + " ");

            for (int node : graph[nodeIdx]) {
                if (!visited[node]) {
                    stack.push(node);
                    visited[node] = true;
                }
            }
        }
    }
}
