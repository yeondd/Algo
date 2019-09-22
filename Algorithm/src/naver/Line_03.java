package naver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Line_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 1;
        int[][] timeTable = new int[num][2];
        
        for(int i = 0; i < num; i++) {
    		timeTable[i][0] = sc.nextInt();
    		timeTable[i][1] = sc.nextInt();
        }

        Arrays.sort(timeTable, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int num1 = o1[1];
				int num2 = o2[1];
				return Integer.compare(num1, num2);
			}
        	
        });

        for(int i = 1; i < num; i++) {
    		int before = timeTable[i - 1][1];
    		int now = timeTable[i][0];
    		
    		if(before > now) {
    			answer++;
    		}
        }
        
        System.out.println(answer);
	}
}
