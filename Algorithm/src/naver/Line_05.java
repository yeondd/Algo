package naver;

import java.util.Scanner;

public class Line_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] map = new int[a][b];
        
        int x = sc.nextInt();
        int y = sc.nextInt();
        map[x][y] = 1;

//      코니가 모눈종이 공간 밖으로 도망 간 경우 문은 코니를 잡을 수 없다
        if(x >= a || y >= b) {
        	System.out.println("fail");
        }
        
        int minTime = x + y;
        int way = factorial(x + y) / (factorial(x) * (factorial(y)));
        System.out.println(minTime);
        System.out.println(way);

	}
	
	public static int factorial(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }

}
