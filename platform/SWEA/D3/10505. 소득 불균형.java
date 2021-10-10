/*
요구사항 : N명의 사람의 소득이 주어졌을 때, 소득이 평균 이하인 사람의 수를 구해라
함수 
	- 입력 : 전체 테케 수
			각 테케 별 ~ 사람 수 N
						공백으로 구분된 N개의 소득
	- 제약 : 1 <= N <= 10,000
			1 <= 각 사람의 소득 <= 100,000
	- 함수 : 각 테케별 평균 이하의 소득을 가진 사람 수
로직 
	N만큼 반복문을 돌면서 소득을 입력받아 모두 더한 후,
	다시 처음부터 끝까지 돌면서 모두 더한 수보다 작으면 ans++
*/
import java.util.Scanner;

public class chan {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();			// 사람의 수
			int[] earnings = new int[N];	// 각 사람의 소득을 담을 배열	
			int average = 0;				// 소득 평균을 저장할 변수
			int ans = 0;					// 평균 이하의 소득을 가진 사람 수를 카운트 할 변수
			// N명의 소득을 입력받아 배열에 저장하면서, 평균을 구하기 위해 모두 더한다.
			for (int i = 0; i < N; i++) {
				earnings[i] = sc.nextInt();
				average += earnings[i];
			}
			average /= N;					// N명의 평균
			// 평균 이하의 소득을 가진 사람이 있으면 카운팅
			for (int e : earnings) {
				if (e <= average) ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
}
