package day08.ch6;

// 시간복잡도>인접리스트 O(정점 + 간선), 인접행렬 O(정점^2) 
public class DFSRecursive {
    static int[][] graph = { {}, { 2, 3, 8 }, { 1, 7 }, { 1, 4, 5 }, { 3, 5 }, { 3, 4 }, { 7 }, { 2, 6, 8 }, { 1, 7 } };
    static boolean[] visited = new boolean[9];

    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for (int node : graph[x]) {
            if (!visited[node]) {
                dfs(node);
                visited[node] = true;
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
    }
}
