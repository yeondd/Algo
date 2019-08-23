package baekjoon;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/3190
 */

class Tuple {
	private int x; // ��
	private int y; // ��
	private char c;
	
	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Tuple(int x, char c) {
		this.c = c;
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	
	public void changeDirection(int flag) {
		if(flag == 0) {
			this.x += 0;
			this.y += 1;
		}
		else if(flag == 1) {
			this.x += 1;
			this.y += 0;
		}
		else if(flag == 2) {
			this.x += 0;
			this.y += -1;
		}
		else if(flag == 3) {
			this.x += -1;
			this.y += 0;
		}
	}
}

public class No3190_snake {

	public static void main(String[] args) {
		int time = 0;
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[][] board = new int[n][n];
		
		// ��� ��ġ ����
		for(int i = 0; i < k; i++) {
			int x = scan.nextInt() - 1;
			int y = scan.nextInt() - 1;

			board[x][y] = 1;
		}
		
		// ���� ��ȯ
		// L - left
		// D - right;
		int L = scan.nextInt();
		Tuple[] direction = new Tuple[L];
		for(int i = 0; i < L; i++) {
			int x = scan.nextInt();
			char c = scan.next().charAt(0);
			direction[i] = new Tuple(x, c);
		}

		// ó�� ���� ��ġ
//		board[0][0] = 2;
		Tuple head = new Tuple(0, 0);
		Tuple tail = new Tuple(0, 0);
		
//-------------------------------------------------------------------------------------------------
	
		int directionIdx = 0;
		int nowHeadRow = head.getX();
		int nowHeadCol = head.getY();
		int nowTailRow = tail.getX();
		int nowTailCol = tail.getY();
		int turnFlag = 0;
		
		while(nowHeadRow < n && nowHeadCol < n && nowTailRow < n && nowTailCol < n) {
			System.out.printf("Time >> %d \n", time);
			
			/*
			 * 이동방향 디폴트: 열 증가
			 * D를 만나면: 행 증가 -> 열 감소 -> 행 감소 -> 열 증가
			 * L을 만나면: 행 감소 -> 열 감소 -> 행 증가 -> 열 증가
			 */
			
			if(directionIdx < direction.length && time == direction[directionIdx].getX()) {
				System.out.println("direction Idx: " + directionIdx + " >> " + direction[directionIdx].getX());
				if(direction[directionIdx].getC() == 'D') {
					turnFlag = (turnFlag + 1) % 4;
				} else if (direction[directionIdx].getC() == 'L') {
					turnFlag = (turnFlag + 3) % 4;
				}
				directionIdx++;
			}
			
			head.changeDirection(turnFlag);
			// 사과가 머리 쪽에 있으면
			if(board[nowHeadRow][nowHeadCol] == 1) {
				// 사과를 없애고
				board[nowHeadRow][nowHeadCol] = 0;
				// 꼬리는 그대로
			} else {
				// 사과가 없으면 꼬리도 다음 칸으로 이동
				tail.changeDirection(turnFlag);
			}

			System.out.printf("\thead) %d %d\n", head.getX(), head.getY());
			System.out.printf("\ttail) %d %d\n", tail.getX(), tail.getY());
			
			nowHeadRow = head.getX();
			nowHeadCol = head.getY();
			nowTailRow = tail.getX();
			nowTailCol = tail.getY();

			time++;
			
		}
		
//-------------------------------------------------------------------------------------------------
//		board[nowHeadRow--][nowHeadCol--] = 2;
//		board[nowTailRow--][nowTailCol--] = 2;
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.print("\n");
//		}
		
		System.out.println(time);
	}
}
