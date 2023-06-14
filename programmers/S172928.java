import java.util.StringTokenizer;

public class S172928 {
    static class Solution {
        static int x, y;
        static int mapW, mapH;
        static String[] map;

        public static int[] solution(String[] park, String[] routes) {
            StringTokenizer st;

            map = park;
            mapW = park[0].length();
            mapH = park.length;

            loop: for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[i].length(); j++) {
                    if (park[i].charAt(j) == 'S') {
                        x = j;
                        y = i;
                        break loop;
                    }
                }
            }

            for (int i = 0; i < routes.length; i++) {
                st = new StringTokenizer(routes[i], " ");
                char dir = st.nextToken().charAt(0);
                int repeat = Integer.parseInt(st.nextToken());

                move(dir, repeat);
            }

            int[] answer = { y, x };
            return answer;
        }

        static void move(char dir, int repeat) {
            int tmpX = x, tmpY = y;
            while (repeat-- > 0) {
                switch (dir) {
                    case 'N':
                        tmpY -= 1;
                        break;
                    case 'E':
                        tmpX += 1;
                        break;
                    case 'S':
                        tmpY += 1;
                        break;
                    case 'W':
                        tmpX -= 1;
                        break;
                }

                if (tmpX < 0 || tmpX >= mapW || tmpY < 0 || tmpY >= mapH || map[tmpY].charAt(tmpX) == 'X') {
                    return;
                }
            }
            x = tmpX;
            y = tmpY;
        }
    }

    public static void main(String[] args) {
        String[] park = { "OSO", "OOO", "OXO", "OOO" };
        String[] routes = { "E 2", "S 3", "W 1" };
        int[] answer = Solution.solution(park, routes);
        System.out.printf("[%d,%d]\n", answer[0], answer[1]);
    }
}