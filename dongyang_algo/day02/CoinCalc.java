package dongyang_algo.day02;

import java.util.LinkedHashMap;
import java.util.Map;

public class CoinCalc {

    public static void main(String[] args) {
        // 잔돈 생성
        Cash cash = new Cash(1260);
        // 화폐 생성
        cash.createCoin(50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1);
        // 잔돈 측량
        cash.calc();
    }
}

class Cash {
    static int cost;
    static int[] coin;
    static Map<Integer, Integer> stat = new LinkedHashMap<>();

    public Cash(int cst) {
        cost = cst;
    }

    public void createCoin(int... values) {
        coin = values;
    }

    public void calc() {
        int cnt;
        for (int i : coin) {
            cnt = cost / i;
            if (cnt > 0)
                stat.put(i, cnt);

            cost %= i;
        }
        printStat();
    }

    private void printStat() {
        for (var st : stat.entrySet()) {
            System.out.printf("%5d원권 개수>%d\n", st.getKey(), st.getValue());
        }
        System.out.println("필요한 현금 수>" + stat.values().stream().mapToInt(i -> i).sum());
    }
}