package day04;

import java.util.Arrays;

// 4. 이진 탐색 2분
class Solution4 {
	public int solution(int[] nums, int target) {
		int answer = -1;
		Arrays.sort(nums);
		int left = 0, right = nums.length;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
		System.out.println(T.solution(new int[] { 2, 5, 7, 8, 10, 15, 20, 24, 25, 30 }, 8));
		System.out.println(T.solution(new int[] { -3, 0, 2, 5, 8, 9, 12, 15 }, 0));
		System.out.println(T.solution(new int[] { -5, -2, -1, 3, 8, 9, 12, 17, 23 }, 2));
		System.out.println(T.solution(new int[] { 3, 6, 9, 12, 17, 29, 33 }, 3));
		System.out.println(T.solution(new int[] { 1, 2, 3, 4, 5, 7, 9, 11, 12, 15, 16, 17, 18 }, 18));
	}
}