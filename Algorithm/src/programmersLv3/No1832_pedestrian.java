package programmersLv3;

import java.util.Stack;

public class No1832_pedestrian {
	public static void main(String[] args) {
		int m = 3;
		int n = 6;
//		int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		System.out.println(solution(m, n, cityMap));
	}
	
	static int MOD = 20170805;
	// 자동차는 오른쪽 또는 아래 방향으로 한 칸씩 이동 가능
	public static int solution(int m, int n, int[][] cityMap) {
		int answer = 0;
		BinaryTree bt = new BinaryTree();
		boolean direction = true; // right
		// left node -> right
		// right node -> down
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {

				if(cityMap[i][j] == 0) {
					if (direction) {
						if(cityMap[i][j + 1] != 1 && cityMap[i + 1][j] != 1) {
							TreeNode left = bt.makeBT(null, new Node(i, j + 1), null);
							TreeNode right = bt.makeBT(null, new Node(i + 1, j), null);
							TreeNode tn = bt.makeBT(left, new Node(i, j), right);
						}
					} else {
						if(cityMap[i + 1][j] != 1 && cityMap[i][j + 1] != 1) {
							TreeNode left = bt.makeBT(null, new Node(i, j + 1), null);
							TreeNode right = bt.makeBT(null, new Node(i + 1, j), null);
							TreeNode tn = bt.makeBT(left, new Node(i, j), right);
						}
					}	
				}
			}
		}
		
		answer = answer % MOD;
	    return answer;
	}
}
