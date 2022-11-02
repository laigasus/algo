package day08.ch2;

// 시간 복잡도 O(N)
public class CoinCalc {
    public static void main(String[] args) {
        int charge = 4200;
        int cnt = 0;
        int[] coin = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

        for (int i = 0; i < coin.length; i++) {
            if (charge == 0)
                break;
            cnt += charge / coin[i];
            charge %= coin[i];
        }
        System.out.println("총 개수>" + cnt);
    }
}