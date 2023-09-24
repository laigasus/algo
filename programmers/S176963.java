import java.util.Arrays;
import java.util.HashMap;

class S176963 {
    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            HashMap<String, Integer> nameMap = new HashMap<>();

            for (int i = 0; i < yearning.length; i++) {
                nameMap.put(name[i], yearning[i]);
            }

            int[] answer = new int[photo.length];

            for (int i = 0; i < photo.length; i++) {
                int sum = 0;

                for (String pic : photo[i]) {
                    sum += nameMap.getOrDefault(pic, 0);
                }
                answer[i] = sum;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        S176963 s176963 = new S176963();
        Solution solution = s176963.new Solution();
        System.out.println(Arrays.toString(solution.solution(
                new String[] { "may", "kein", "kain", "radi" },
                new int[] { 5, 10, 1, 3 },
                new String[][] {
                        { "may", "kein", "kain", "radi" },
                        { "may", "kein", "brin", "deny" },
                        { "kon", "kain", "may", "coni" }
                })));

        System.out.println(Arrays.toString(solution.solution(
                new String[] { "kali", "mari", "don" },
                new int[] { 11, 1, 55 },
                new String[][] {
                        { "kali", "mari", "don" },
                        { "pony", "tom", "teddy" },
                        { "con", "mona", "don" }
                })));

        System.out.println(Arrays.toString(solution.solution(
                new String[] { "may", "kein", "kain", "radi" },
                new int[] { 5, 10, 1, 3 },
                new String[][] {
                        { "may" },
                        { "kein", "deny", "may" },
                        { "kon", "coni" }
                })));
    }
}
