import java.util.HashMap;
import java.util.Map;

class S176963 {
    public static void main(String[] args) {

        String[] name = { "may", "kein", "kain", "radi" };
        int[] yearning = { 5, 10, 1, 3 };
        String[][] photo = {
                { "may", "kein", "kain", "radi" },
                { "may", "kein", "brin", "deny" },
                { "kon", "kain", "may", "coni" }
        };
        int[] answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < yearning.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (String member : photo[i]) {
                sum += map.getOrDefault(member, 0);
            }
            answer[i] = sum;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}