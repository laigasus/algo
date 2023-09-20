import java.util.HashMap;
import java.util.TreeMap;

//[PCCP 모의고사 #1] 1번 - 외톨이 알파벳
public class S121683 {
    private class Solution {
        public static String solution(String input_string) {
            StringBuilder sb = new StringBuilder();
            HashMap<Character, Integer> hashMap = new HashMap<>();

            for (char c : input_string.toCharArray()) {
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            }

            TreeMap<Character, Integer> sortedMap = new TreeMap<>(hashMap);

            for (char c : sortedMap.keySet()) {
                int len = hashMap.get(c);
                if (len >= 2) {
                    int startIdx = input_string.indexOf(c);
                    String subStr = input_string.substring(startIdx, startIdx + len);
                    if (!subStr.equals((c + "").repeat(len))) {
                        sb.append(c);
                        hashMap.put(c, 0);
                    }
                }
            }

            String answer = sb.toString();
            return answer.length() == 0 ? "N" : answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution("edeaaabbccd"));
        System.out.println(Solution.solution("eeddee"));
        System.out.println(Solution.solution("string"));
        System.out.println(Solution.solution("zbzbz"));
    }
}
