import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2738 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][][] arr = new int[2][N][M];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < arr[i][j].length; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[0][i].length; j++) {
                sb.append(arr[0][i][j] + arr[1][i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
