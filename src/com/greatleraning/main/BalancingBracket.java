package com.greatleraning.main;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBracket {
	public static void main(String[] args) {
		String expression = "([[{}]])";
		boolean result = checkBalance(expression);
		if(result) {
			System.out.print("The entered String has Balanced Brackets");
		}else {
			System.out.print("The entered Strings do not contain Balanced Brackets");
		}
	}

	private static boolean checkBalance(String expression) {
		// to check the odd values
		if(expression.length()%2 == 1)
			return false;
		
		Stack<Character> stack = new Stack<>();
		for(int i=0; i < expression.length(); i++) {
			char character = expression.charAt(i);
			//checking for open brackets
			if(character == '{' || character == '(' || character == '[')
				stack.push(character);
			else {
				// checking for closed brackets
				char c = stack.pop();
				switch(character) {
				case '}':
					if(c != '{')
					return false;
					break;
					
				case ')':
					if(c != '(')
					return false;
					break;
				case ']':
					if(c != '[')
					return false;
					break;
				}
			}
		}
				
		return stack.empty();
	}
}
