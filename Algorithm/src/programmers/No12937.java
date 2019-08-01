package programmers;

/*
 * 짝수와 홀수
 * https://programmers.co.kr/learn/courses/30/lessons/12937
 * 엄청 쉬운데 깔끔하게 잘 푼 것 같아서 기분 좋다ㅎㅎ
 */

public class No12937 {

	public static void main(String[] args) {
		System.out.println(solution(29));
	}

	public static String solution(int num) {
	      return (num % 2 == 0) ? "Even" : "Odd";
	  }
}
