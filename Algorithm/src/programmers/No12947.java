package programmers;

/*
 * ÇÏ»şµå ¼ö
 * https://programmers.co.kr/learn/courses/30/lessons/12947
 */

public class No12947 {

	public static void main(String[] args) {

		System.out.println(solution(13));

	}

	public static boolean solution(int x) {
		int sum = 0;
		int num = x;

		while(num > 0) {
			sum += num % 10;
			num = num / 10;
		}

		return (x % sum == 0) ? true : false;
	}
}
