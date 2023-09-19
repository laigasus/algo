package day02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution3 {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	HashMap<Character, Integer> map = new HashMap<>(Map.of(
			'U', 0,
			'R', 1,
			'D', 2,
			'L', 3));

	private class Robot {
		int r, c;

		Robot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int[] solution(int N, String moves) {
		Robot robot = new Robot(0, 0);
		for (char command : moves.toCharArray()) {
			int dir = map.get(command);
			int nr = robot.r + dr[dir];
			int nc = robot.c + dc[dir];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}

			robot.r = nr;
			robot.c = nc;
		}
		return new int[] { robot.r, robot.c };
	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();
		System.out.println(Arrays.toString(T.solution(5, "RRRDDDUUUUUUL")));
		System.out.println(Arrays.toString(T.solution(7, "DDDRRRDDLL")));
		System.out.println(Arrays.toString(T.solution(5, "RRRRRDDDDDU")));
		System.out.println(Arrays.toString(T.solution(6, "RRRRDDDRRDDLLUU")));
	}
}