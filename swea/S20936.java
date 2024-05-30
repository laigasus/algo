import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class S20936 {
    static int N;
    static int[] arr;
    static int[] sortedArr;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            arr = new int[N + 2];

            for (int i = 1; i <= N; i++) {
                arr[i] = sc.nextInt();
            }

            sortedArr = IntStream.rangeClosed(0, N + 1).toArray();
            arr[N + 1] = -1;
            sortedArr[N + 1] = -1;

            // 총 이동횟수와
            // 매 시도마다의 빈칸 위치 출력
            sort(N + 1, new StringBuilder(), 0);
        }
    }


    private static void sort(int xPos, StringBuilder sb, int cnt) {
        if (cnt != 0) {
            sb.append(xPos).append(' ');
        }

        if (Arrays.equals(sortedArr, arr)) {
            System.out.println(cnt);
            System.out.println(sb);
            return;
        }

        int needNumber;
        if (xPos == N + 1) {
            needNumber = N;
        } else {
            needNumber = xPos;
        }

        for (int needNumberIdx = 1; needNumberIdx <= N + 1; needNumberIdx++) {
            if (arr[needNumberIdx] == needNumber) {
                swap(xPos, needNumberIdx);
                sort(needNumberIdx, sb, cnt + 1);
                return;
            }
        }
    }

    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}