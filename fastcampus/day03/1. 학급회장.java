package day03;

import java.util.HashMap;

class Solution {
	public char solution(String votes) {
		char answer = ' ';
		HashMap<Character, Integer> hashMap = new HashMap<>(answer, answer);
		for (char vote : votes.toCharArray()) {
			hashMap.put(vote, hashMap.getOrDefault(vote, 0) + 1);
		}

		int max = Integer.MIN_VALUE;
		for (char key : hashMap.keySet()) {
			if (hashMap.get(key) > max) {
				max = hashMap.get(key);
				answer = key;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution("BACBACCACCBDEDE"));
		System.out.println(T.solution("AAAAABBCCDDDD"));
		System.out.println(T.solution("AABBCCDDEEABCB"));
	}
}