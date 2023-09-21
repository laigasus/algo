package day04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 3. 최대수입스케줄. 1시간. 말을 못알아 들어서 시간 걸림
class Solution3 {
	public int solution(int[][] schedules) {
		// 결과값 초기화
		int answer = 0;

		// nums 배열을 두 번째 요소를 기준으로 내림차순 정렬
		Arrays.sort(schedules, (a, b) -> b[1] - a[1]);

		// 가장 큰 두 번째 요소 값(maxd) 추출
		int maxPriceDate = schedules[0][1];

		// 우선순위 큐 생성 (큰 값이 먼저 나오도록 설정)
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		// nums 배열을 순회하며 우선순위 큐에 첫 번째 요소 추가
		for (int leftDate = maxPriceDate; leftDate >= 1; leftDate--) {
			for (int[] schedule : schedules) {
				if (schedule[1] == leftDate) {
					pq.add(schedule[0]);
				}
			}

			// 우선순위 큐가 비어있지 않다면 가장 큰 값을 결과값에 더함
			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}

		// 결과값 반환
		return answer;
	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();
		System.out
				.println(T.solution(
						new int[][] { { 50, 2 }, { 20, 1 }, { 40, 2 }, { 60, 3 }, { 30, 3 }, { 30, 1 } }));
		System.out.println(T.solution(new int[][] { { 50, 2 }, { 40, 2 }, { 20, 1 }, { 10, 1 } }));
		System.out.println(T.solution(new int[][] { { 70, 5 }, { 60, 1 }, { 80, 2 }, { 70, 1 } }));
	}
}