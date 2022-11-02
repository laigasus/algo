package day08.ch5;

// 시간 복잡도 O(N^2)
public class KnightsMove {
    final static int BOARD_SIZE = 8;
    final static int KNIGHT_DISTANCE = 5;

    public static void main(String[] args) {
        int x = 4, y = 5;
        int cnt = 0;
        for (int i = 1; i <= BOARD_SIZE; i++) {
            for (int j = 1; j <= BOARD_SIZE; j++) {
                if (Math.pow(x - i, 2) + Math.pow(y - j, 2) == KNIGHT_DISTANCE) {
                    cnt++;
                }
            }
        }
        System.out.println("경우의 수>" + cnt);
    }
}
