/* 5215. 햄버거 다이어트
- 요구사항 : 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,
			정해진 칼로리 이하의 조합 중 선호하는 햄버거를 조합하여 점수를 출력해라
- 함수 
	- 입력 : 테케 수 T
			각 테케 - 첫째줄 ~ 재료의 수 N 제한 칼로리 L
					둘째~N째줄 ~ 맛에 대한 점수 Ti 칼로리 Ki
	- 제약 : 1 <= N <= 20
			1 <= L <= 10^4
			1 <= Ti, Ki <= 10^3
	- 출력 : 각 테케 별 제한 칼로리 이하의 조합 중에서 맛에 대한 점수가 가장 높은 햄버거의 점수
- 부분 집합을 사용한다.
	모든 부분 집합을 바탕으로, 칼로리의 합과 접수의 합을 계산해서 
	칼로리가 제한칼로리 이하인 것 중 점수가 가장 높은 것을 출력
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

// 부분집합
public class 5215 {
    
	static int N, L;		
	static int[] scores;
	static int[] calories;
	static int highest;
	static boolean[] isSelected;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);		// 재료의 수 
			L = Integer.parseInt(line[1]);		// 제한 칼로리
			scores = new int[N];				
			calories = new int[N];
			highest = 0;
			numbers = new int[N];
			isSelected = new boolean[N + 1];
			// 입력
			for (int i = 0; i < N; i++) {
				line = br.readLine().split(" ");	
				scores[i] = Integer.parseInt(line[0]);	// 맛에 대한 점수
				calories[i] = Integer.parseInt(line[1]);// 칼로리
			}
			
			hambergerDiet(0);
			System.out.println("#" + t + " " + highest);
		}
	}
	private static void hambergerDiet(int cnt) {
		// 기저 조건 - 부분 집합이 완성
		if (cnt == N) {
			
			int cal = 0;
			int sco = 0;
			// 부분 집합에서 점수의 합과 칼로리의 합 계산
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					cal += calories[i];
					sco += scores[i];
				}
			}
			// 칼로리의 합이 제한 칼로리 이하일 때
			if (cal <= L) {
				highest = Math.max(sco, highest);	// 점수의 합이 최댓값인 것을 저장
			}
			
			return ;
		}
		
		isSelected[cnt] = true;		// 부분집합에 현재 원소 포함
		hambergerDiet(cnt + 1);		// 뒤에서 가능한 모든 경우의 수 다 하기
		
		isSelected[cnt] = false;	// 부분집합에 현재 원소 미포함
		hambergerDiet(cnt + 1);		// 현재 원소를 선택하지 않았을 때 뒤에서 가능한 모든 경우의 수 다 하기
	}
}
