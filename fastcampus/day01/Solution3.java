package day01;
import java.util.Arrays;
import java.util.Hashtable;

class Solution3 {
    public int[] twoSum(final int[] nums, final int target) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        for (int x : nums) {
            int y = target - x;
            if (table.containsKey(y)) {
                if (x < y) {
                    return new int[] { x, y };
                } else {
                    return new int[] { y, x };
                }
            } else {
                table.put(x, y);
            }

        }
        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        Solution3 T = new Solution3();
        StringBuilder sb = new StringBuilder();

        sb.append(Arrays.toString(T.twoSum(new int[] { 7, 3, 2, 13, 9, 15, 8, 11 }, 12))).append('\n');
        sb.append(Arrays.toString(T.twoSum(new int[] { 21, 12, 30, 15, 6, 2, 9, 19, 14 }, 24))).append('\n');
        sb.append(Arrays.toString(T.twoSum(new int[] { 12, 18, 5, 8, 21, 27, 22, 25, 16, 2 }, 28))).append('\n');
        sb.append(Arrays.toString(T.twoSum(new int[] { 11, 17, 6, 8, 21, 9, 19, 12, 25, 16, 2 }, 26))).append('\n');
        sb.append(Arrays.toString(T.twoSum(new int[] { 7, 5, 12, -9, -12, 22, -30, -35, -21 }, -14))).append('\n');
        sb.append(Arrays.toString(T.twoSum(new int[] { 7, 5, 12, 20 }, 15))).append('\n');

        System.out.print(sb);
    }
}