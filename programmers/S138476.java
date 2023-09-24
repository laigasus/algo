import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//10분
public class S138476 {

    static class Solution {
        public static int solution(int k, int[] tangerine) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (var t : tangerine) {
                map.put(t, map.getOrDefault(t, 0) + 1);
            }

            List<Integer> elements = new ArrayList<>(map.values());
            Collections.sort(elements, Collections.reverseOrder());

            int answer = 0;
            for (var e : elements) {
                k -= e;
                answer++;
                if (k <= 0) {
                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(6, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 }));
        System.out.println(Solution.solution(4, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 }));
        System.out.println(Solution.solution(2, new int[] { 1, 1, 1, 1, 2, 2, 2, 3 }));
    }
}
