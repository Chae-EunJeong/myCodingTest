/* 1218. 괄호 짝짓기
- 요구사항 : 4종류의 괄호문자들이 주어졌을 때,
            괄호문자들의 짝이 모두 맞는지 확인해라.
- 함수
    - 입력 (10개의 테케, 한 테케당 두 줄씩 입력받음)
            각 테케의 첫줄에는 테케의 길이
                     둘째줄에는 테케 (괄호들)
    - 출력 : 각 테케 번호, 공백, 유효성 여부 
    - 유효성 여부 - 1: 유효함   0: 유효하지 않음
    - 4짝의 괄호, 총 8개 : (, ), [, ], {, }, <, >
- 로직
    열림 괄호인 (, [, {, < 가 들어오면 +1씩 하고,
    닫힘 괄호인 ), ], }, > 가 들어오면 -1씩 한다.
    (여기서, 괄호의 순서를 고려하여 +- 1씩 해준다.)
    네 가지 중 0이 아닌게 있으면 유효하지 않고, 모두 0이면 유효하다.
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D4_1218_괄호짝짓기 {
    
	// 괄호 문자들의 짝이 모두 맞는지 유효성 검사하는 함수
	static int checkValidity(int tlen, char[] brackets) {
		int[] match = new int[4];			// 4가지 괄호의 짝이 맞는지 확인하기 위한 변수
		for (int i = 0; i < tlen; i++) {
			char input = brackets[i];		// char 배열로 들어온 괄호 하나하나씩을 비교하기 위한 input 변수
			// 괄호 짝 마다, 열림 괄호는 +1 하고, 닫힘 괄호는 -1을 해서 짝이 맞으면 0이 되도록 한다.
			switch (input) {
				case '(':
					match[0]++;
					break;
				case ')':
					match[0]--;
					break;
				case '[':
					match[1]++;
					break;
				case ']':
					match[1]--;
					break;
				case '{':
					match[2]++;
					break;
				case '}':
					match[2]--;
					break;
				case '<':
					match[3]++;
					break;
				case '>':
					match[3]--;
					break;
			}
		}
		// 4개의 괄호가 짝이 모두 맞는지 검사
		for (int i = 0; i < match.length; i++) {
			// 0이 아닌 게 있으면 짝이 맞지 않으므로 유효하지 않음 반환
			if (match[i] != 0) {
				return 0;
			}
		}
		// 짝이 모두 맞다면 유효함 반환
		return 1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 총 테스트 케이스 수는 10개
		for (int t = 1; t <= 10; t++) {
			int tlen = Integer.parseInt(br.readLine());	// 입력될 괄호 문자열의 길이
			char[] brackets = new char[tlen];
			brackets = br.readLine().toCharArray();		// 괄호 문자열을 입력받아 char array에 저장
			
			System.out.printf("#%d %d%n", t, checkValidity(tlen, brackets));
		}
	}

}
