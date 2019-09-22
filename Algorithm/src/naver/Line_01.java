package naver;

import java.util.Scanner;

public class Line_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
        int messageNum = sc.nextInt();
        int[] message = new int[messageNum];
        int consumer = sc.nextInt();
        
        int sum = 0;
        for(int i = 0; i < messageNum; i++) {
        	message[i] = sc.nextInt();
        	sum += message[i];
        }

        int time = 0;
        int messageIdx = consumer - 1;
        int[][] progress = new int[consumer][sum];
        
        for(int i = 0; i < consumer; i++) {
        	progress[i][0] = message[i];
        }
        time++;
        
        for(int i = 0; i < consumer; i++) {
        	time++;
        	for(int j = 0; j < sum; j++) {
        		progress[i][j] = 1;
        	}
        }
        
	}

}
