import java.util.Arrays;

public class S161990 {
    private static class Solution {
        public int[] solution(String[] wallpaper) {
            int lux = Integer.MAX_VALUE, rdx = Integer.MIN_VALUE, luy = Integer.MAX_VALUE, rdy = Integer.MIN_VALUE;
            for (int x = 0; x < wallpaper.length; x++) {
                for (int y = 0; y < wallpaper[x].length(); y++) {
                    if (wallpaper[x].charAt(y) == '#') {
                        lux = Math.min(lux, x);
                        rdx = Math.max(rdx, x);
                        luy = Math.min(luy, y);
                        rdy = Math.max(rdy, y);
                    }
                }
            }
            return new int[] { lux, luy, rdx + 1, rdy + 1 };
        }
    }

    public static void main(String[] args) {
        String[][] testCases = {
                { ".#...", "..#..", "...#." },
                { "..........", ".....#....", "......##..", "...##.....", "....#....." },
                { ".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...." },
                { "..", "#." }
        };

        StringBuilder sb = new StringBuilder();

        for (var testcase : testCases) {
            sb.append(Arrays.toString(new Solution().solution(testcase))).append('\n');
        }

        System.out.print(sb);
    }
}
