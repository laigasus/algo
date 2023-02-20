import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 참고 https://st-lab.tistory.com/145 */
public class P1931 {
    final static int START = 0, END = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            meetings[i][START] = Integer.parseInt(st.nextToken());
            meetings[i][END] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] m1, int[] m2) {
                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                return m1[END] == m2[END] ? m1[START] - m2[START] : m1[END] - m2[END];
            }
        });

        int cnt = 0, end = 0;

        for (int i = 0; i < N; i++) {
            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if (end <= meetings[i][START]) {
                end = meetings[i][END];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}