import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P1931F {
    static int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int N = readInt();

        while (N-- > 0) {
            int start = readInt();
            int end = readInt();

            first = Math.min(first, start);
            last = Math.max(last, start);

            map.put(start, Math.min(end, map.getOrDefault(start, Integer.MAX_VALUE)));
        }

        System.out.println(calc(new Schedule(first, 0)));
    }

    private static class Schedule {
        int time, depth;

        public Schedule(int time, int depth) {
            this.time = time;
            this.depth = depth;
        }

    }

    private static int calc(Schedule schedule) {
        int result = 0;

        Stack<Schedule> stack = new Stack<>();
        stack.push(schedule);

        while (!stack.isEmpty()) {
            Schedule now = stack.pop();
            if (now.depth > map.size()) {
                continue;
            }

            if (now.time > last) {
                result = Math.max(result, now.depth);
                continue;
            }

            for (int time = now.time; time <= last; time++) {
                if (map.containsKey(time)) {
                    stack.push(new Schedule(map.get(time), now.depth + 1));
                }
            }
        }

        return result;
    }

    private static int readInt() throws IOException {
        int rs = 0;
        boolean isNegative = false;
        int c = System.in.read();
        while (c <= ' ') {
            c = System.in.read();
        }
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        while (c >= '0' && c <= '9') {
            rs = rs * 10 + c - '0';
            c = System.in.read();
        }
        return isNegative ? -rs : rs;
    }
}
