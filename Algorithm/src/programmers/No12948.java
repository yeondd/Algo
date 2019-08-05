package programmers;

/*
 * 핸드폰 번호 가리기
 * https://programmers.co.kr/learn/courses/30/lessons/12948
 */

public class No12948 {

	public static void main(String[] args) {
		System.out.println(solution("01033334444"));
	}
	
	public static String solution(String phone_number) {
		String answer = "";
		int len = phone_number.length();
		
		for(int i = 0; i < len - 4; i++) answer += "*";
		answer += phone_number.substring(len - 4);
		
	    return answer;
	}
}
