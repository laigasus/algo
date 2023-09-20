package day03;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution3 {
	public int[] solution(String s) {
		int[] alphabet = new int[5];
		int[] answer = new int[alphabet.length];

		for (char c : s.toCharArray()) {
			alphabet[c - 'a']++;
		}

		int max = IntStream.of(alphabet).max().getAsInt();

		for (int i = 0; i < alphabet.length; i++) {
			answer[i] = max - alphabet[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution3 T = new Solution3();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
