package day03;

import java.util.Collections;
import java.util.HashMap;

class Solution4 {
	public int solution(String s) {
		HashMap<Character, Integer> hashMap = new HashMap<>();

		for (char c : s.toCharArray()) {
			hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
		}

		StringBuilder sb= new StringBuilder();
		sb.isEmpty();
		
		int odd = 0;
		for (char c : hashMap.keySet()) {
			int num = hashMap.get(c);
			if (num % 2 == 1) {
				odd++;
			}
		}
		return odd > 0 ? s.length() - odd + 1 : s.length();
	}

	public static void main(String[] args) {
		Solution4 T = new Solution4();
		System.out.println(T.solution("abcbbbccaaeee"));
		System.out.println(T.solution("aabbccddee"));
		System.out.println(T.solution("fgfgabtetaaaetytceefcecekefefkccckbsgaafffg"));
		System.out.println(T.solution("aabcefagcefbcabbcc"));
		System.out.println(T.solution("abcbbbccaa"));
	}
}