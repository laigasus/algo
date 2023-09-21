package day04;

//5. 랜선 자르기 7분
class Solution5 {

	private final int MAX_CABLE_LEN = 1_000_000;

	public int solution(int[] cables, int N) {
		int answer = 0;

		int left = 1, right = MAX_CABLE_LEN;

		while (left < right) {
			int cnt = 0;
			int middle = left + (right - left) / 2;
			for (int cable : cables) {
				cnt += cable / middle;
			}

			if (cnt < N) {
				right = middle;
			} else {
				answer = Math.max(answer, middle);
				left = middle + 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution5 T = new Solution5();
		System.out.println(T.solution(new int[] { 802, 743, 457, 539 }, 11));
		System.out.println(T.solution(new int[] { 8593, 9617, 9313, 4513, 7505, 5457, 8257, 4689, 2657 }, 100));
		System.out.println(T.solution(new int[] { 93, 97, 93, 53, 75, 57, 85, 89, 67 }, 30));
	}
}