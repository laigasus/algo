import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 참조: https://st-lab.tistory.com/119
public class P2580 {
    static final int BD_SIZE = 9;
    static int[][] sudoku = new int[BD_SIZE][BD_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < BD_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BD_SIZE; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc(0, 0);
    }

    public static void calc(int row, int col) {

        // 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
        if (col == 9) {
            calc(row + 1, 0);
            return;
        }

        // 행과 열이 모두 채워졌을 경우 출력 후 종료
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.print(sb);

            // 재귀 스택 무시 즉시 종료
            System.exit(0);
        }

        // 미 기입된 값 확인
        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    sudoku[row][col] = i;
                    calc(row, col + 1);
                }
            }
            sudoku[row][col] = 0;
            return;
        }

        calc(row, col + 1);

    }

    static boolean check(int row, int col, int v) {
        // 수평 검사
        for (int idx = 0; idx < 9; idx++) {
            if (sudoku[row][idx] == v) {
                return false;
            }
        }

        // 수직 검사
        for (int idx = 0; idx < 9; idx++) {
            if (sudoku[idx][col] == v) {
                return false;
            }
        }

        // 박스 검사
        int pfRow = (row / 3) * 3, pfCol = (col / 3) * 3;
        for (int i = pfRow; i < pfRow + 3; i++) {
            for (int j = pfCol; j < pfCol + 3; j++) {
                if (sudoku[i][j] == v) {
                    return false;
                }
            }
        }

        return true;
    }
}