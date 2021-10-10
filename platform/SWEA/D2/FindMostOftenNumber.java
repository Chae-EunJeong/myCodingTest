/* 1204. 최빈수 구하기
- 요구사항 : 1000명의 정수를 입력받아 최빈수를 이용한 평균을 구해라
- 함수
    - 입력 : 첫째줄 ~ 테스트 케이스 수 T
            둘째줄 ~ 각 테스트 케이스의 번호 tt
            세번째줄 ~ 공백으로 구분된 1000명의 점수 scores[]에 저장
    - 제약 : 0 <= 각 scores <= 100
            최빈수가 여러개일때는 가장 큰 점수 출력
    - 출력 : 테스트케이스만큼의 라인에 각 테케 번호와 최빈수
- 손코딩
    테스트 케이스 수를 입력받는다.
    테스트 케이스 수만큼 반복문을 돌면서
        테스트 케이스 번호를 입력받는다. 
        학생들이 받은 점수에 해당하는 scores[] 인덱스로 넣어 1씩 더한다.
        점수를 다 입력하면 0부터 100까지의 점수에 해당하는 학생 수를 돌면서
            가장 많은 학생수를 가진 점수(인덱스)를 찾는다. -> 최빈수
        테케별 결과에 최빈수를 저장하고, 반복문 내 변수를 초기화한다.
    테스트 케이스 수만큼 반복하면서
        각 테스트케이스 번호와 최빈수를 출력한다.
*/

import java.util.Scanner;

public class FindMostOftenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();       // 총 테케 수
        int[] results = new int[T+1];   // 테케별 최빈수
        int student = 0;            // 현재 가장 많은 점수의 학생 수
        int score = 0;
        int num = 0;
        for (int t = 1; t <= T; t++) {
            int tt = sc.nextInt();
            int[] scores = new int[101];    // 1000명의 점수를 0부터 100까지의 배열에 저장
 
            for (int i = 0; i < 1000; i++) {
                num = sc.nextInt();
                scores[num]++;
            }
 
            for (int j = 0; j <= 100; j++) {
                if(student <= scores[j] && score < j) {                   
                    student = scores[j];
                    score = j;
                }
            } 
            results[tt] = score;
            student = 0;
            score = 0;
        }
         
        for (int k = 1; k <= T; k++) {
            System.out.printf("#%d %d%n", k, results[k]);
        }
        sc.close();
    }
}
