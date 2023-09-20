import java.util.Arrays;
import java.util.HashMap;

//2022 KAKAO BLIND RECRUITMENT>주차 요금 계산
public class S92341 {
    static class Solution {
        public static int[] solution(int[] fees, String[] records) {
            int[] cars = new int[10000];
            HashMap<Integer, Integer> recordMap = new HashMap<>();

            int timePolicy = fees[0];
            int feePolicy = fees[1];
            int overTimePolicy = fees[2];
            int overFeePolicy = fees[3];

            for (String record : records) {
                String[] info = record.split(" ");
                int time = cvrtTime(info[0]);
                int carNum = Integer.parseInt(info[1]);

                if (recordMap.containsKey(carNum)) {
                    int diff = time - recordMap.get(carNum);
                    cars[carNum] += diff;
                    recordMap.remove(carNum);
                } else {
                    recordMap.put(carNum, time);
                }
            }

            int endTime = cvrtTime("23:59");
            for (HashMap.Entry<Integer, Integer> entry : recordMap.entrySet()) {
                int diff = endTime - entry.getValue();
                cars[entry.getKey()] += diff;
            }

            return Arrays.stream(cars).filter(i -> i > 0).map(i -> {
                int defaultFee = feePolicy;
                if (i <= timePolicy) {
                    return defaultFee;
                } else {
                    int overFee = (int) Math.ceil((i - timePolicy) * 1.0 / overTimePolicy) * overFeePolicy;
                    return defaultFee + overFee;
                }
            }).toArray();
        }

        private static int cvrtTime(String s) {
            String[] tmp = s.split(":");
            return 60 * Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]);
        }
    }

    public static void main(String[] args) {
        int[] rs = Solution.solution(new int[] { 180, 5000, 10, 600 },
                new String[] { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                        "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" });

        System.out.println(Arrays.toString(rs));
    }
}
