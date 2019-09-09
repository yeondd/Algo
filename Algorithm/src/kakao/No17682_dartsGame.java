package kakao;

class dartsScoreInfo {
	int score;		// 0 ~ 9
	String bonus;		// S or D or T
	String option = ".";	// * or # or null

	public dartsScoreInfo() {}
	
	public dartsScoreInfo(int score, String bonus) {
		this.score = score;
		this.bonus = bonus;
	}
	
	public dartsScoreInfo(String score, String bonus, String option) {
		this.score = Integer.parseInt(score);
		this.bonus = bonus;
		this.option = option;
	}
	
	public void setScore(String score) {
		this.score = Integer.parseInt(score);
	}
}

public class No17682_dartsGame {

	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		System.out.println(solution(dartResult));
	}

	public static int solution(String dartResult) {
		int answer = 0;
		dartsScoreInfo[] chance = new dartsScoreInfo[3];
		String[] dartSlice = dartResult.split("");
		
		int i = 0;
		int count = 0;

		while(i < dartSlice.length - 1) {
			chance[count] = new dartsScoreInfo();
			
			//score
			if(dartSlice[i].equals("1") && dartSlice[i + 1].equals("0")) {
				chance[count].setScore("10");
				i += 2;
			}
			else {
				chance[count].setScore(dartSlice[i]);
				i++;
			}
			
			// bonus
			{
				chance[count].bonus = dartSlice[i];
				i++;
			}
			
			// option
			if(i < dartSlice.length) {
				if(dartSlice[i].equals("*") || dartSlice[i].equals("#")) {
					chance[count].option = dartSlice[i];
					i++;
				}
			}

//			System.out.printf("score: %d, bonus: %s, option: %s\n", chance[count].score, chance[count].bonus, chance[count].option);
			count++;
			
		}

		int[] temp = new int[3];
		for(i = 0; i < chance.length; i++) {
			int score = chance[i].score;
			String bonus = chance[i].bonus;
			String option = chance[i].option;

			switch (bonus) {
			case "S":
				temp[i] = score;
				break;
				
			case "D":
				temp[i] = score * score;
				break;
				
			case "T":
				temp[i] = score * score * score;
				break;
			}
			
			// 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배
			if(option.equals("*")) {
				// 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배
				if(i == 0) {
					temp[i] *= 2;
				} else {
					temp[i - 1] *= 2;
					temp[i] *= 2;
				}
			}
			else if(option.equals("#")) {
				temp[i] *= (-1);
			}
		}
		
		answer = temp[0] + temp[1] + temp[2];
	    return answer;
	}
}
