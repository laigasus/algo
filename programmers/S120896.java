import java.util.TreeMap;

public class S120896 {

    static class Solution {
        public static String solution(String s) {
            TreeMap<Character, Integer> dict = new TreeMap<>();

            for (char c : s.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }

            StringBuilder sb = new StringBuilder();

            for (var entry : dict.entrySet()) {
                if (entry.getValue() == 1) {
                    sb.append(entry.getKey());
                }
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution("abcabcadc"));
        System.out.println(Solution.solution("abdc"));
        System.out.println(Solution.solution("hello"));
    }
}
