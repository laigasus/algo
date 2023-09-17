import java.io.IOException;
import java.util.HashMap;

public class P1450F3 {
    static int N, C;
    static int[] stuffs;
    static HashMap<Integer, Long> dp;

    public static void main(String[] args) throws IOException {
        N = readInt();
        C = readInt();

        stuffs = new int[N];
        dp = new HashMap<>(); // dp를 HashMap으로 변경
        for (int i = 0; i < N; i++) {
            stuffs[i] = readInt();
        }

        dp.put(0, 1L); // 무게가 0인 경우는 항상 가능하므로 1로 초기화
        for (int stuff : stuffs) {// 각 물건에 대해
            HashMap<Integer, Long> nextDp = new HashMap<>(dp); // 다음 무게 조합을 저장할 새로운 HashMap 생성
            for (int w : dp.keySet()) {// 현재까지의 각 무게에 대해
                int nextW = w + stuff; // 다음 무게 계산
                if (nextW <= C) { // 다음 무게가 용량 C를 초과하지 않는 경우
                    nextDp.put(nextW, nextDp.getOrDefault(nextW, 0L) + dp.get(w)); // 해당 무게의 경우의 수를 가져옴
                }
            }
            dp = nextDp; // dp를 nextDp로 업데이트
        }

        long cnt = 0;// 전체 경우의 수
        for (long cases : dp.values()) {// 무게별 경우의 수를 모두 가져옴
            cnt += cases;
        }

        System.out.println(cnt);
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
