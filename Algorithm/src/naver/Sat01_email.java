package naver;
import java.util.regex.*;

public class Sat01_email {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] emails = {"d@co@.com", "a@abc.com", "b@def.com", "c@ghi.net"};
		String[] emails2 = {"abc@defx.xyz", "abc.def@x.com", "abc", "abc@defx"};
		System.out.println(solution(emails2));
	}
	
	public static int solution(String[] emails) {
		int answer = 0;
		String regex = "[a-z.]+(@{1})[a-z]+(.com|.net|.org)";
		/* 
		 * [a-z.]+: 소문자 알파벳이랑 . 만 들어갈 수 있음. 근데 그게 1개 이상.
		 * (@{1}): @이라는 문자를 그냥 한 묶음으로 처리해서, 1번만 나오도록. 그런데 그냥 @만 넣어도 될 듯.
		 * [a-z]+: 위랑 같은 의미지만 여기선 .을 넣을 수 없음.
		 * (.com|.net|.org): or로 묶어서 이 중 하나가 일치하는지 확인. 점 자체가 정규식에 있는 명령어라 같이 묶어서 체크함.
		 */
		Pattern p = Pattern.compile(regex);
		
		for(String s: emails) {
			if(Pattern.matches(regex, s)) {
				answer++;
			}
		}
		return answer;
	}

}
