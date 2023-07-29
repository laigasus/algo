import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class P2580F {
    static final int BD_SIZE = 9;
    static final int BD_SIZE_S = 3;
    static final String SPACE = " ";

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

        if (col == BD_SIZE) {
            calc(row + 1, 0);
            return;
        }

        if (row == BD_SIZE) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < BD_SIZE; i++) {
                StringJoiner sj = new StringJoiner(SPACE);
                for (int j = 0; j < BD_SIZE; j++) {
                    sj.add(Integer.toString(sudoku[i][j]));
                }
                sb.append(sj).append('\n');
            }
            System.out.print(sb);

            // 재귀 스택 무시 즉시 종료
            System.exit(0);
        }

        // 미 기입된 값 확인
        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= BD_SIZE; i++) {
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

    private static boolean check(int row, int col, int v) {
        // 수평, 수직 검사
        for (int idx = 0; idx < BD_SIZE; idx++) {
            if (sudoku[row][idx] == v || sudoku[idx][col] == v) {
                return false;
            }
        }

        // 박스 검사
        int pfRow = (row / BD_SIZE_S) * BD_SIZE_S, pfCol = (col / BD_SIZE_S) * BD_SIZE_S;
        for (int i = pfRow; i < pfRow + BD_SIZE_S; i++) {
            for (int j = pfCol; j < pfCol + BD_SIZE_S; j++) {
                if (sudoku[i][j] == v) {
                    return false;
                }
            }
        }

        return true;
    }
}