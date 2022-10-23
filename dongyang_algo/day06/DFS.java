package day06;

public class DFS {
    public static boolean[] visited = new boolean[9];
    static int[][] graph = { {}, { 2, 3, 8 }, { 1, 7 }, { 1, 4, 5 }, { 3, 5 }, { 3, 4 }, { 7 }, { 2, 6, 8 }, { 1, 7 } };

    // DFS 함수 정의
    public static void dfs(int x) {
        // 현재 노드를 방문 처리
        visited[x] = true;
        System.out.print(x + " ");
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int node : graph[x]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
    }

}
