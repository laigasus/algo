public class S67256 {
    static class Solution {
        static class Point {
            int x, y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public static String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();

            for (int num : numbers) {
                sb.append(getWhichHandUsed(hand, num));
            }

            return sb.toString();
        }

        static Point left = new Point(0, 3);
        static Point right = new Point(2, 3);

        private static final int KEYPAD_WIDTH = 3;
        private static final int ZERO_X = 1, ZERO_Y = 3;

        private static char getWhichHandUsed(String hand, int num) {
            int nx = (num == 0) ? ZERO_X : (num - 1) % KEYPAD_WIDTH;
            int ny = (num == 0) ? ZERO_Y : (num - 1) / KEYPAD_WIDTH;

            char rs = switch (num) {
                case 1, 4, 7 -> 'L';
                case 3, 6, 9 -> 'R';
                default -> getNearestHand(new Point(nx, ny), hand);
            };

            if (rs == 'L') {
                left = new Point(nx, ny);
            } else {
                right = new Point(nx, ny);
            }

            return rs;
        }

        private static char getNearestHand(Point next, String hand) {
            int leftDiff = calcDist(left, next);
            int rightDiff = calcDist(right, next);

            return switch (Integer.signum(leftDiff - rightDiff)) {
                case -1 -> 'L';
                case 1 -> 'R';
                default -> Character.toUpperCase(hand.charAt(0));
            };
        }

        private static int calcDist(Point p1, Point p2) {
            return Math.abs(p2.x - p1.x) + Math.abs(p2.y - p1.y);
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(
                new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 },
                "right"));

        System.out.println(Solution.solution(
                new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 },
                "left"));

        System.out.println(Solution.solution(
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 },
                "right"));
    }
}
