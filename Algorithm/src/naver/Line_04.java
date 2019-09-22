package naver;

import java.util.ArrayList;
import java.util.Scanner;

public class Line_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] seat = new int[size];
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int max = 0;
        for(int i = 0; i < size; i++) {
        	seat[i] = sc.nextInt();
        	
            if(seat[i] == 1) {
        		list.add(max);
        		max = 0;
        	}
        	else {
        		max++;
        	}
        }
        
        int answer = 0;
        for(int i : list) {
        	if(i > answer) {
        		answer = i;
        	}
        }

        if(answer % 2 == 0) {
        	answer = answer / 2;
        }
        else {
        	answer = (answer / 2) + 1;
        }
        
        System.out.println(answer);
	}

}
