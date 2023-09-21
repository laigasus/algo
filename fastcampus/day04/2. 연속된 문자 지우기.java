package day04;

import java.util.Arrays;
import java.util.Stack;

// 2. 연속된 문자 지우기 13분. Deque로 하려다가 Stack로 바꿈
class Solution2 {
	public String solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return Arrays.toString(stack.toArray());
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		System.out.println(T.solution("acbbcaa"));
		System.out.println(T.solution("bacccaba"));
		System.out.println(T.solution("aabaababbaa"));
		System.out.println(T.solution("bcaacccbaabccabbaa"));
		System.out.println(T.solution("cacaabbc"));
	}
}