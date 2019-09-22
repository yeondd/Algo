package naver;

import java.util.*;
import java.util.regex.Pattern;

public class Naver_02 {
	public static void main(String[] args) {
		String[] record = {"RECEIVE abcd@naver.com", "RECEIVE zzkn@naver.com", "DELETE", "RECEIVE qwerty@naver.com", "SAVE", "RECEIVE QwerTY@naver.com"};
		String[] record2 = {"DELETE", "SAVE", 
				"RECEIVE Qhrud@naver.com", 
				"SAVE", "SAVE", 
				"RECEIVE qhrud@naver.com", 
				"SAVE", "DELETE", "SAVE"};
		String[] answer = solution(record2);
		
		for(String str : answer) {
			System.out.println(str);
		}
	}
	
	static Stack<String> temp;
	static Queue<String> mailBox;
	
	public static String[] solution(String[] record) {
		String[] answer;
		temp = new Stack<String>();
		mailBox = new LinkedList<String>();
		
		for(int i = 0; i < record.length; i++) {
			if(record[i].charAt(0) == 'R') {
				String email[] = record[i].split(" ");
				temp.push(email[1]);
			}
			else if(record[i].charAt(0) == 'D') {
				if(!temp.isEmpty()) {
					temp.pop();
				}
			}
			else if(record[i].charAt(0) == 'S') {
				temp = reverseStack(temp);
				
				while(!temp.isEmpty()) {
					mailBox.offer(temp.pop());
				}
			}
		}
		
		answer = new String[mailBox.size()];
		int i = 0;
		while(!mailBox.isEmpty()) {
			answer[i] = mailBox.poll();
//			System.out.println(answer[i]);
			
			i++;
		}
		
		return answer;
	}
	
	static Stack<String> reverseStack(Stack<String> stack) {
		Stack<String> reverse = new Stack<String>();
		while(!stack.isEmpty()) {
			reverse.push(stack.pop());
		}
		return reverse;
	}

}
