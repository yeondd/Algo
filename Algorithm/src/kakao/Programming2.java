package kakao;

import java.util.*;

public class Programming2 {

	public static void main(String[] args) {
		String p1 = "(()())()";
		String p2 = ")(";
		String p3 = "()))((()";
		System.out.println(solution(p3));
	}

	static Stack<Character> stack;
	static String str;
	
	public static boolean isRightMatch(String s) {
		if(s.length() == 0) return false;
		
        for(int i = 0; i < s.length(); i++) {
        	char pChar = s.charAt(i);
        	
        	if(pChar == '(') {
        		stack.push(pChar);
        	} 
        	else {
        		if(!stack.isEmpty()) {
        			stack.pop();
        		}
        	}
        }
        
        return stack.isEmpty();
	}
	
	public static int findPop(String s) {
		System.out.println("test str: " + s);
		
		stack.clear();
		int i = 0;
		
        for(i = 0; i < s.length(); i++) {
        	char pChar = s.charAt(i);
        	
        	if(pChar == '(') {
        		stack.push(pChar);
        	} 
        	else {
        		if(!stack.isEmpty()) {
        			stack.pop();
        			break;
        		}
        	}
        }
        
		return i - 1;
	}
	
	public static void dividStr(String p) {
		int idx = findPop(p);
        String u;
        String v;
        
        if(idx == p.length() - 1) {
        	change(p);
        }
        
        if(idx != 0) {
        	if(p.length() > 2) {
            	u = p.substring(0, idx);
            	v = p.substring(idx);
        	} else {
            	u = p.substring(0, idx + 1);
            	v = "";
        	}
        } else {
        	u = p.substring(0, 2);
        	v = p.substring(idx + 2);
        }

		System.out.println("u: " + u);
		System.out.println("v: " + v);
		
		if(!isRightMatch(u)) {
			System.out.println("u divid");
			if(u.length() > 2) dividStr(u);
			else change(u);
		}
        if(!isRightMatch(v) && v.length() > 2) {
			System.out.println("v divid");
        	if(v.length() > 2) dividStr(v);
			else change(v);
        }
	}
	
	public static void change(String p) {
		// 앞 뒤 삭제 
		String str = "";
		int length = p.length();
		str = p.substring(1, length - 1);

		System.out.println(">>> str: " + str);
		// 괄호 반대로 
		for(int i = 0; i < str.length(); i++) {
			
		}
		
		// ( ) 붙이기 
		p += "(";
		p += ")";
	}
	
	public static String solution(String p) {
        String answer = "";
        stack = new Stack<Character>();
        str = p;
        String u;
        String v;
        
//        if(isRightMatch(str)) {
//        	return str;
//        }
        
        dividStr(p);
		
        return answer;
    }
}
