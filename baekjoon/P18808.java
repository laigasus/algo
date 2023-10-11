import java.io.IOException;

public class P18808 {
    static int N, M; // 노트북의 세로, 가로, 스티커의 개수
    static int[][] surface; // 노트북의 격자
    static int[][] stickers; // 현재 스티커의 격자
    static int row, col; // 현재 스티커의 세로, 가로

    public static void main(String[] args) throws IOException {

        N = readInt();
        M = readInt();
        int K = readInt();

        surface = new int[N][M]; // 노트북을 0으로 초기화

        while (K-- > 0) { // 스티커의 개수만큼 반복
            row = readInt();
            col = readInt();
            stickers = new int[row][col]; // 스티커를 0으로 초기화

            for (int i = 0; i < row; i++) { // 스티커의 정보를 입력받음
                for (int j = 0; j < col; j++) {
                    stickers[i][j] = readInt();
                }
            }

            attach(); // 스티커를 붙이는 함수 호출
        }

        System.out.println(count()); // 노트북에서 스티커가 붙은 칸의 수 출력
    }

    public static void attach() { // 스티커를 붙이는 함수
        for (int t = 0; t < 4; t++) { // 스티커를 0, 90, 180, 270도 회전시키면서 시도
            if (check()) {
                return; // 스티커를 붙일 수 있으면 붙이고 종료
            }

            rotate(); // 스티커를 시계방향으로 90도 회전시킴
        }
    }

    public static boolean check() { // 스티커를 붙일 수 있는지 확인하는 함수
        for (int i = 0; i <= N - row; i++) { // 노트북의 모든 위치에 대해
            for (int j = 0; j <= M - col; j++) {
                if (match(i, j)) { // 스티커를 붙일 수 있는 위치라면
                    paste(i, j); // 스티커를 붙임
                    return true; // true 반환
                }
            }
        }
        return false; // 스티커를 붙일 수 없으면 false 반환
    }

    public static boolean match(int y, int x) { // 스티커와 노트북이 겹치지 않는지 확인하는 함수
        for (int i = y; i < y + row; i++) { // 스티커와 노트북의 격자를 비교함
            for (int j = x; j < x + col; j++) {
                if (stickers[i - y][j - x] == 1 && surface[i][j] == 1) { // 둘 다 1이면 겹침
                    return false; // false 반환
                }
            }
        }
        return true; // 겹치지 않으면 true 반환
    }

    public static void paste(int x, int y) { // 스티커를 붙이는 함수
        for (int i = x; i < x + row; i++) { // 노트북에 스티커의 값을 더함
            for (int j = y; j < y + col; j++) {
                surface[i][j] += stickers[i - x][j - y];
            }
        }
    }

    public static void rotate() { // 스티커를 시계방향으로 90도 회전시키는 함수
        int[][] tmp = new int[col][row]; // 회전된 스티커를 임시로 저장할 배열
        for (int i = 0; i < row; i++) { // 스티커의 각 칸에 대해
            for (int j = 0; j < col; j++) {
                tmp[j][row - 1 - i] = stickers[i][j]; // 시계방향으로 90도 회전한 위치에 값을 복사함
            }
        }
        stickers = tmp; // 스티커를 회전된 배열로 갱신함
        int t = row; // 스티커의 세로와 가로도 바뀜
        row = col;
        col = t;
    }

    public static int count() { // 노트북에서 스티커가 붙은 칸의 수를 세는 함수
        int cnt = 0;
        for (int i = 0; i < N; i++) { // 노트북의 모든 칸에 대해
            for (int j = 0; j < M; j++) {
                if (surface[i][j] > 0) {
                    cnt++; // 값이 0보다 크면 스티커가 붙은 것이므로 카운트함
                }
            }
        }
        return cnt;
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}
