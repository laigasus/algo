import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        game(N, 0, 0, 0);
    }

    private static void game(int remain, int sk, int cy, int turn) {
        if (remain == 0) {
            System.out.println(turn % 2 == 1 ? "SK" : "CY");

            System.exit(0);
        }

        if (turn % 2 == 1) {
            if (remain - 3 > 0) {
                game(remain - 3, sk + 3, cy, turn + 1);
            }
            game(remain - 1, sk + 1, cy, turn + 1);
        } else {
            if (remain - 3 > 0) {
                game(remain - 3, sk, cy + 3, turn + 1);
            }
            game(remain - 1, sk, cy + 1, turn + 1);
        }
    }
}
