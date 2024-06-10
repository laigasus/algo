import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class P1043F {
    static int N, M;
    static boolean[] knows;
    static int[][] parties;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        parent = IntStream.rangeClosed(0, N).toArray();
        parties = new int[M][];
        knows = new boolean[N + 1];
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {
            knows[sc.nextInt()] = true;
        }


        for (int i = 0; i < parties.length; i++) {
            parties[i] = new int[sc.nextInt()];
            boolean someOneKnows = false;
            parties[i][0] = sc.nextInt();
            for (int j = 1; j < parties[i].length; j++) {
                parties[i][j] = sc.nextInt();
                union(parties[i][j - 1], parties[i][j]);

                if (knows[parties[i][j]]) {
                    someOneKnows = true;
                }
            }

            if (someOneKnows) {
                spread(parties[i][parties[i].length - 1]);
            }
        }


        int cnt = 0;
        loop:
        for (int[] party : parties) {
            for (int member : party) {
                if (knows[find(member)]) {
                    continue loop;
                }
            }

            cnt++;
        }

        System.out.println(cnt);

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void spread(int x) {
        knows[x] = true;
        if (x == parent[x]) {
            return;
        }

        spread(parent[x]);
    }
}