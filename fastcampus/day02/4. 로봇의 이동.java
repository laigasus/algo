package day02;

import java.util.Arrays;

class Solution4 {
	static final int[] dr = { -1, 0, 1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };
	static final int BOARD_SIZE = 100;

	private class Robot {
		int r, c;

		Robot(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int[] solution(String moves) {
		Robot robot = new Robot(0, 0);
		int d = 1;

		for (char command : moves.toCharArray()) {
			switch (command) {
				case 'G' -> {
					robot.r += dr[d];
					robot.c += dc[d];
				}
				case 'R' -> {
					d = (d + 1) % 4;
				}
				case 'L' -> {
					d = (d + 3) % 4;
				}
			}
		}
		return new int[] { robot.r, robot.c };
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
		System.out.println(Arrays.toString(T.solution("GGGRGGG")));
		System.out.println(Arrays.toString(T.solution("GGRGGG")));
		System.out.println(Arrays.toString(T.solution("GGGGGGGRGGGRGGRGGGLGGG")));
		System.out.println(Arrays.toString(T.solution("GGLLLGLGGG")));
	}
}