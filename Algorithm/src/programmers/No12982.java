package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No12982 {
	public static void main(String[] args) {
		int[] d = {9, 1, 1, 1, 1, 1};
		int budget = 9;
		System.out.println(solution(d, budget));
	}

	public static int solution(int[] d, int budget) {
		int answer = 0;
		int cost = 0;
		List<Integer> canditate = new LinkedList<Integer>();
		
		// sort
		Arrays.sort(d);
		int i = 0;
		// 제일 직은 값끼리 차례로 더해서 예산보다 크거나 작을때까지 비교
		for(i = 0; i < d.length; i++) {
			// 다음 값을 더하면 에산보다 크지만, 
			if(cost + d[i] > budget) break;
			else {
				cost += d[i];
				canditate.add(i);
			}
		}

		System.out.println("1st cost: " + cost + " / i: " + i);
		i--;
		// 더하기 전엔 예산보다 작은 경우 가장 큰 인덱스 값이랑 비교
		// lastIdx: ArrayList에 넣은 마지막 값. 최적화 할 값.
		int lastIdx = canditate.get(i);
		int maxRangeIdx = d.length;
		
		while(i > 0 && cost < budget) {

//			System.out.println("last idx: " + lastIdx + " / maxRangeIdx: " + maxRangeIdx);
			for(int j = lastIdx + 1; j < maxRangeIdx; j++) {
				// 현재까지 더한 값에서 제일 큰 값을 빼고 그 다음으로 큰 값을 더했을때 예산을 넘지 않으면 그 값으로 대체
				if(cost - d[j - 1] + d[j] <= budget) {
					canditate.remove(i);
					canditate.add(j);
					cost = cost - d[j - 1] + d[j];
				}
				else { 
					System.out.println("break");
					break; 
				}
			}
			
			i--;
			lastIdx = canditate.get(i);
			maxRangeIdx = canditate.get(i + 1);
		}
		
		answer = canditate.size();
		return answer;
	}
}
