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
			int x = scan.nextInt();
			int y = scan.nextInt();

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
		
		while(nowHeadRow < n -1 && nowHeadCol < n - 1 && nowTailRow < n -1 && nowTailCol < n - 1) {
			time++;
			
			// �Ӹ��� ���� ĭ���� �̵�
			head.setY(nowHeadCol++);
			
			// ����� �Ӹ� �ʿ� ������
			if(board[nowHeadRow][nowHeadCol] == 1) {
				// ����� ���ְ�
				board[nowHeadRow][nowHeadCol] = 0;
				// ������ �״��
			} else {
				// ����� ������ ������ ���� ĭ���� �̵�
				tail.setY(nowTailCol++);
			}
			
			// ���� ��ȯ
			if(time == direction[directionIdx].getX()) {
				if(direction[directionIdx].getC() == 'D') {
					nowHeadRow++; /////// <- �� ���̰� 1 �̻��϶� ���� �ٲ��???
				} else if (direction[directionIdx].getC() == 'L') {
					nowHeadRow--;
				}
				
				head.setX(nowHeadRow);
				tail.setX(nowTailRow);
				directionIdx++;
			}
		}
		

//-------------------------------------------------------------------------------------------------
		board[nowHeadRow][nowHeadCol] = 2;
		board[nowTailRow][nowTailCol] = 2;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
		
		System.out.println(time);
	}
}
