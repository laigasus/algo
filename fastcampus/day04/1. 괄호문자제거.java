package day04;

import java.util.Stack;

// 1. 괄호문자제거 4분
class Solution {
	public String solution(String str) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (char c : str.toCharArray()) {
			switch (c) {
				case '(' -> stack.push('(');
				case ')' -> stack.pop();
				default -> {
					if (stack.isEmpty()) {
						sb.append(c);
					}
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
		System.out.println(T.solution("((AF)B)(D)E(F)"));
		System.out.println(T.solution("(Aab)(EsG)FFD"));
		System.out.println(T.solution("(YYYDD)sh(kkf(hfs))"));
	}
}
