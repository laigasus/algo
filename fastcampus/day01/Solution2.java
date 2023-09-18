package day01;
import java.util.Arrays;

class Solution2 {
    public int[] twoSum(final int[] nums, final int target) {
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] { nums[left], nums[right] };
            }
        }

        return new int[] { 0, 0 };
    }

    public static void main(String[] args) {
        Solution2 T = new Solution2();
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