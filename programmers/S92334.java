import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

//2022 KAKAO BLIND RECRUITMENT>신고 결과 받기
public class S92334 {

    class Solution {
        public static int[] solution(String[] users, String[] reports, int k) {
            HashMap<String, HashSet<String>> reportMap = new HashMap<>();
            LinkedHashMap<String, Integer> userMap = new LinkedHashMap<>();

            for (String user : users) {
                reportMap.put(user, new HashSet<>());
                userMap.put(user, 0);
            }

            for (String report : reports) {
                String[] cmd = report.split(" ");
                String who = cmd[0];
                String target = cmd[1];
                reportMap.get(target).add(who);
            }

            for (var entry : reportMap.entrySet()) {
                if (entry.getValue().size() >= k) {
                    entry.getValue().forEach(user -> userMap.put(user, userMap.get(user) + 1));
                }
            }

            int index = 0;
            int[] answer = new int[userMap.size()];
            for (String user : userMap.keySet()) {
                answer[index++] = userMap.get(user);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] rs = Solution.solution(
                new String[] { "muzi", "frodo", "apeach", "neo" },
                new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" },
                2);

        System.out.println(Arrays.toString(rs));

        rs = Solution.solution(
                new String[] { "con", "ryan" },
                new String[] { "ryan con", "ryan con", "ryan con", "ryan con" },
                3);

        System.out.println(Arrays.toString(rs));
    }
}
