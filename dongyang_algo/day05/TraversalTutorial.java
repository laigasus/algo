package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TraversalTutorial {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        char[] alpha = { 'L', 'R', 'U', 'D' };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int x = 0, y = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (input[i].charAt(0) == alpha[j]) {
                    int nx = x + dir[j][0];
                    int ny = y + dir[j][15];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                        continue;
                    x = nx;
                    y = ny;
                }
            }
        }
        System.out.println((x + 1) + " " + (y + 1));
    }
}
