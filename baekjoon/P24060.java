import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P24060 {
    static int[] A, tmp;
    static int K, cnt = 0, rs = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        merge_sort(A, 0, A.length - 1);
        System.out.println(rs);
    }

    static void merge_sort(int A[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(A, p, q);
            merge_sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    static void merge(int A[], int p, int q, int r) {
        int i = p, j = q + 1, t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = A[i++];
        }

        while (j <= r) {
            tmp[t++] = A[j++];
        }

        t = 0;
        i = p;

        while (i <= r) {
            cnt++;
            if (cnt == K) {
                rs = tmp[t];
                break;
            }
            A[i++] = tmp[t++];
        }
    }
}