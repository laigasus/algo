import java.util.Scanner;

public class P5639 {
    static int[] tree = new int[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int idx = 0;
            while (sc.hasNext())
                tree[idx++] = sc.nextInt();

            postOrder(0, idx - 1);
        }

        System.out.print(sb);
    }

    static void postOrder(int n, int end) {
        if (n > end)
            return;

        int mid = n + 1;
        while (mid <= end && tree[mid] < tree[n])
            mid++;

        postOrder(n + 1, mid - 1);
        postOrder(mid, end);
        sb.append(tree[n]).append('\n');
    }
}