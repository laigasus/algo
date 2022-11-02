package day08.ch5;

// 시간 복잡도 O(N^3)
public class IsTimeHaveThree {
    final static int MINUTE = 60;
    final static int SECOND = 60;

    public static void main(String[] args) {
        int cnt = 0;
        int hour = 5;
        for (int h = 0; h <= hour; h++) {
            for (int m = 0; m < MINUTE; m++) {
                for (int s = 0; s < SECOND; s++) {
                    if (("" + h + m + s).contains("3")) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println("경우의 수>" + cnt);
    }
}
