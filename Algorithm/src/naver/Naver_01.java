package naver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Naver_01 {
// not 01
// this is #2
	public static void main(String[] args) {
//		System.out.println(solution(1));
//		System.out.println(solution(2));
//		System.out.println(solution(4));
		System.out.println(solution(9));
	}

	public static long solution(int n) {
		long answer = 0;
		ArrayList<Long> list = new ArrayList<Long>();
		
		list.add((long) (1 * 2));
		
		for(int i = 2; i < (n * 2); i++) {
			for(int j = 1; j < i; j++) {
//				System.out.println(j + ", " + i);
				long temp = factorial(j, i);
				
				if(!list.contains(temp) && temp >= 0) {
//					System.out.println("\t-> " + temp);
					list.add(temp);
				}
			}
		}
		
		Collections.sort(list);
		
		answer = list.get(n - 1);
		return answer;
	}
	
	public static long factorial(int n, int m) {
        int result = 1;
        for(int i = n; i <= m; i++) {
            result *= i;
        }
        
        return result;
    }
}
