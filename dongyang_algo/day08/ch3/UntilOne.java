package day08.ch3;

// 시간 복잡도 O(N)
public class UntilOne {
    public static void main(String[] args) {
        int n = 25, k = 5, cnt = 0;
        while (n != 1) {
            if (n % k != 0) {
                n -= 1;
            } else {
                n /= k;
            }
            cnt++;
        }

        System.out.println("총 횟수>" + cnt);
    }
}