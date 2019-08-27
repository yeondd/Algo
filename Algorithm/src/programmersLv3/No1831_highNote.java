package programmersLv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class No1831_highNote {

	public static void main(String[] args) {

		System.out.println(solution(41));
	}
	
	public static int solution(int n) {
	   int answer = 0;
	   
	   // 제곱근으로 만들수 있는 최대 개수 알아내기
	   int numberOfStar = (int) Math.cbrt(n);
//	   System.out.println(numberOfStar);
	   int size = numberOfStar * 3;
	   char[] notes = new char[size];
	   Arrays.fill(notes, '+');
	   notes[0] = '*';
	   
	   int[] starLocation = new int[3];
	   LinkedList<int[]> tree = new LinkedList<int[]>();

	   for(int i = 0; i < 3; i++) {
		   starLocation[i] = i + 1;
	   }
	   tree.add(starLocation);
	   System.out.println(tree.get(0)[0]);
	   
	   for(int[] arr: tree) {
		   for(int i: arr) {
			   System.out.print(i + " ");
		   }
		   System.out.println(6%20170805);
	   }
	   
	   return answer;
	}
}
