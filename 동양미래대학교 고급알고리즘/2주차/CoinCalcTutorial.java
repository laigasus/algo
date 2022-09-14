/**
 * CoinCalcTutorial
 */

public class CoinCalcTutorial {

    static int cost = 1260;
    static int[] coin = { 500, 100, 50, 10 };

    public static void main(String[] args) {
        // 화폐 생성 및 잔돈 측량
        // 화폐 계산
        calc(coin, cost);
    }

    void createInfo(int cost, int... values) {
        this.cost = cost;
    }

    static void calc(int[] coin, int cost) {
        int cnt = 0;
        for (int i : coin) {
            cnt += cost / i;
            System.out.printf("%d원 동전 개수>%d\n", i, cost / i);
            cost %= i;
        }
        System.out.println("필요한 동전의 개수>" + cnt);
    }
}