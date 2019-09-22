package naver;

import java.util.*;
/*
 * 혜지한테 받아온
 */

public class Naver_03 {

	public static void main(String[] args) {
		int[] cook_times = {};
		int[][] order = {};
		int k = 0;
		
		int[] answer = solution(cook_times, order, k);
		for(int i : answer) {
			System.out.println(i);
		}

	}
	
	/*
	 *  단계를 수행하기 전에 반드시 먼저 완료해야 하는 단계 개수와 k 단계를 완료하는데 최소 몇 분이 걸리는지 구하려 합니다. 
	 */
	public static int[] solution(int[] cook_times, int[][] order, int k) {
        int[] answer = new int[2];
        int  size = cook_times.length;
        int visited[]=new int[size];
        int min[]=new int[size];
        for(int i=0;i<size;i++) {
            min[i]=cook_times[i];
            visited[i]=0;
         }
         
         int end=order.length;
         
         for(int i=0;i<end;i++) {
            int pre=order[i][0]-1;
            int now=order[i][1]-1;
            
            if(visited[pre]== 0) visited[now] += 1;
            else visited[now]+=visited[pre];
        }
        
        int count = 0;
        for(int i = 0; i < k - 1; i++) {
        	if(visited[i] == 1) {
        		count++;
        	}
        }
        
        answer[0] = count;
        answer[1] = min[k - 1];

        return answer;
    }

}
