import java.util.HashMap;
import java.util.Map;

class S178871 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String[] players = { "mumu", "soe", "poe", "kai", "mine" };
        String[] callings = { "kai", "kai", "mine", "mine" };
        int N = players.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(players[i], i);
        }

        for (String call : callings) {
            int idx = map.get(call);
            String frontPlayer = players[idx - 1];
            players[idx - 1] = players[idx];
            players[idx] = frontPlayer;

            map.replace(players[idx - 1], idx - 1);
            map.replace(players[idx], idx);
        }

        String[] answer = players;

        for (String s : answer) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}