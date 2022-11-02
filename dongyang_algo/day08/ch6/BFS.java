package day08.ch6;

import java.util.LinkedList;
import java.util.Queue;

// 시간복잡도>인접리스트 O(정점 + 간선), 인접행렬 O(정점^2) 
public class BFS {
    static int[][] graph = { {}, { 2, 3, 8 }, { 1, 7 }, { 1, 4, 5 }, { 3, 5 }, { 3, 4 }, { 7 }, { 2, 6, 8 }, { 1, 7 } };
    static boolean[] visited = new boolean[9];
    static Queue<Integer> q= new LinkedList<>();

    public static void main(String[] args) {
        bfs(1);
    }

    public static void bfs(int start){
        q.offer(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int x= q.poll();
            System.out.print(x+ " ");

            for(int node : graph[x]){
                if(!visited[node]){
                    q.offer(node);
                    visited[node]=true;
                }
            }
        }
    }
}
