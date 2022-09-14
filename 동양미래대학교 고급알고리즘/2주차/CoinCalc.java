import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * CoinCalc
 * link> 백준 11047
 */

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
    static int cnt;
    static Map<Integer, Integer> stat = new LinkedHashMap<>();;

    public Cash(int cst) {
        cost = cst;
    }

    public void createCoin(int... values) {
        coin = values;
    }

    public void calc() {
        for (int i : coin) {
            cnt += cost / i;
            stat.put(i, cost / i);
            cost %= i;
        }
        printStat();
    }

    private void printStat() {
        for (Entry<Integer, Integer> st : stat.entrySet()) {
            System.out.printf("%d원 동전 개수>%d\n", st.getKey(), st.getValue());
        }
        System.out.println("필요한 동전의 개수>" + cnt);
    }
}