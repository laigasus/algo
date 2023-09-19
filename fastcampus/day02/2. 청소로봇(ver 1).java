package day02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution2 {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static final int BOARD_SIZE = 100;
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

	public int[] solution(String moves) {
		Robot robot = new Robot(0, 0);
		for (char command : moves.toCharArray()) {
			int dir = map.get(command);
			int nr = robot.r + dr[dir];
			int nc = robot.c + dc[dir];

			if (nr < 0 || nc < 0 || nr >= BOARD_SIZE || nc >= BOARD_SIZE) {
				continue;
			}

			robot.r = nr;
			robot.c = nc;
		}
		return new int[] { robot.r, robot.c };
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		System.out.println(Arrays.toString(T.solution("RRRDDDLU")));
		System.out.println(Arrays.toString(T.solution("DDDRRRDDLL")));
		System.out.println(Arrays.toString(T.solution("RRRRRRDDDDDDUULLL")));
		System.out.println(Arrays.toString(T.solution("RRRRDDDRRDDLLUU")));
	}
}