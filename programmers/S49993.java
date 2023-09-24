public class S49993 {
    // 40분
    static class Solution {
        public static int solution(String skill, String[] skill_trees) {
            int answer = 0;
            for (var skill_tree : skill_trees) {
                StringBuilder sb = new StringBuilder();

                for (char c : skill_tree.toCharArray()) {
                    if (skill.indexOf(c) != -1) {
                        sb.append(c);
                    }
                }

                if (skill.startsWith(sb.toString())) {
                    answer++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
    }
}
