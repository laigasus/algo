import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class P1450 {
    static int N, C;
    static int[] stuff;
    static ArrayList<Integer> left, right = new ArrayList<>();

    static {
        left = new ArrayList<>();
        right = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        N = readInt();
        C = readInt();

        stuff = new int[N];
        for (int i = 0; i < N; i++) {
            stuff[i] = readInt();
        }

        // 가능한 모든 무게 조합 만들기
        makeWeightCombination(0, N / 2, 0, left);
        makeWeightCombination(N / 2, N, 0, right);

        // 조합 정렬. 우항에 대해 이진탐색을 수행하므로 left는 정렬할 필요 없음
        Collections.sort(right);

        long cnt = 0;
        // 왼쪽 리스트의 각 요소에 대해
        for (int l : left) {
            // 오른쪽 리스트에서 C - l보다 작거나 같은 가장 큰 수의 인덱스 찾기
            int r = upperBound(right, C - l);
            // 그 인덱스는 C보다 작거나 같은 무게 조합의 개수와 같음
            cnt += r;
        }

        System.out.println(cnt);
    }

    private static void makeWeightCombination(int start, int end, int sum, ArrayList<Integer> list) {
        // 합이 C보다 크면 종료
        if (sum > C) {
            return;
        }

        // 끝에 도달하면 리스트에 합 추가
        if (start >= end) {
            list.add(sum);
            return;
        }

        // 현재 물건을 포함하는 경우와 포함하지 않는 경우 모두 탐색
        makeWeightCombination(start + 1, end, sum + stuff[start], list);
        makeWeightCombination(start + 1, end, sum, list);
    }

    private static int upperBound(ArrayList<Integer> list, int target) {
        int start = 0;
        int end = list.size();

        // 이진 탐색으로 target보다 작거나 같은 가장 큰 수의 인덱스 찾기
        while (start < end) {
            int mid = (start + end) / 2;

            if (list.get(mid) <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}