import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class P2580 {
    static final int BD_SIZE = 9;
    static final int BD_SIZE_S = 3;
    static final String SPACE = " ";

    static int[] rowBits, colBits;
    static int[][] boxBits;
    static int[][] sudoku;

    static {
        rowBits = new int[BD_SIZE];
        colBits = new int[BD_SIZE];
        boxBits = new int[BD_SIZE_S][BD_SIZE_S];
        sudoku = new int[BD_SIZE][BD_SIZE];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < BD_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BD_SIZE; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) {
                    continue;
                }

                int v = sudoku[i][j];
                rowBits[i] |= 1 << v;
                colBits[j] |= 1 << v;
                boxBits[i / BD_SIZE_S][j / BD_SIZE_S] |= 1 << v;
            }
        }

        calc(0, 0);
    }

    static void calc(int row, int col) {
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
            for (int n = 1; n <= BD_SIZE; n++) {
                if (isValid(row, col, n)) {
                    place(row, col, n);
                    calc(row, col + 1);
                    displace(row, col, n);
                }
            }
            return;
        }

        calc(row, col + 1);
    }

    private static void place(int row, int col, int n) {
        sudoku[row][col] = n;
        rowBits[row] |= 1 << n;
        colBits[col] |= 1 << n;
        boxBits[row / BD_SIZE_S][col / BD_SIZE_S] |= 1 << n;
    }

    private static void displace(int row, int col, int n) {
        sudoku[row][col] = 0;
        rowBits[row] &= ~(1 << n);
        colBits[col] &= ~(1 << n);
        boxBits[row / BD_SIZE_S][col / BD_SIZE_S] &= ~(1 << n);
    }

    private static boolean isValid(int row, int col, int v) {
        // 수평 검사
        if ((rowBits[row] & (1 << v)) != 0) {
            return false;
        }

        // 수직 검사
        if ((colBits[col] & (1 << v)) != 0) {
            return false;
        }

        // 박스 검사
        if ((boxBits[row / BD_SIZE_S][col / BD_SIZE_S] & (1 << v)) != 0) {
            return false;
        }

        return true;
    }
}