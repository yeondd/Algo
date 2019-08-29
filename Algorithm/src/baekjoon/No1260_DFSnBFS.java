package baekjoon;

/*
 * DFS¿Í BFS
 * https://www.acmicpc.net/problem/1260
 * Âü°í: https://javannspring.tistory.com/174
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1260_DFSnBFS {
	static int[][] graph;
	static boolean[] visit;
	static int n;
	static int m;
	static int v;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		v = scan.nextInt();
		
		graph = new int[n][n];
		visit = new boolean[n];
		
		int x;
		int y;
		
		for(int i = 0; i < m; i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			graph[x - 1][y - 1] = graph[y - 1][x - 1] = 1;
		}
		
		DFS(v - 1);
		
		int idx = 0;
		for(boolean b: visit) {
			visit[idx++] = false;
		}
		System.out.println();
		
		BFS(v - 1);
	}
	
	public static void DFS(int start) {
		visit[start] = true;
		System.out.print(start + 1 + " ");
		
		for(int i = 0; i < n; i++) {
			if(graph[start][i] == 1 && !visit[i]) {
				DFS(i);
			}
		}
	}
	
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visit[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			System.out.print(temp + 1+ " ");

			for(int i = 0; i < n; i++) {
				if(graph[temp][i] == 1 && !visit[i]) {
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
