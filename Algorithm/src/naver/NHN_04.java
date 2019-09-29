package naver;

import java.util.ArrayList;
import java.util.Scanner;

public class NHN_04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int town = scan.nextInt();
		int fuel = scan.nextInt();
		int way = scan.nextInt();
		int money = 100;
		int[][] map = new int[town][town];
		boolean[][] visited = new boolean[town][town];

		System.out.print(town + " ");
		System.out.print(fuel + " ");
		int x = 0;
		int y = 0;
		for(int i = 0; i < way; i++) {
			for(int j = 0; j < way; j++) {
				String wayStr = scan.nextLine();
				System.out.println(wayStr);
//				x = wayStr.charAt(0) - 'A';
				System.out.print(wayStr.charAt(0) + " ");
//				y = wayStr.charAt(2) - 'A';
//				System.out.print(y + " ");
//				int m = wayStr.charAt(4) - '0';
//				System.out.print(m + " \n");
//				
//				map[x][y] = m;
//				map[y][x] = m;
			}
		}
		
		/////////

		ArrayList<Integer> list = new ArrayList<Integer>();
		x = 0;
		for(int i = 0; i < way; i++) {
			for(int j = 0; j < town; j++) {
				y = j;
				System.out.println(x + " " + y + " " + map[x][y]);
				if(map[x][y] != 0 && !visited[x][y]) {
					visited[x][y] = true;
					visited[y][x] = true;
					fuel = fuel - map[x][y] + 10;
					money = money + 300 - 100;
					
					list.add(x);
					x = y;
					break;
				}
			}
			
			x = 0;
		}

	}

}
