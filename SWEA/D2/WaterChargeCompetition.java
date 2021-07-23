/* 1284. 수도 요금 경쟁
- 요구사항 : 수도 회사의 요금 측정 방식이 아래와 같을 때, 
            한달간 사용한 수도의 양(W)에 대해 더 저렴한 회사의 측정 요금을 구해라.
    - 측정 방식
        - A사 : 1리터당 P원
        - B사 : 월간 사용량이 R리터 이하일 때 기본 요금 Q원,
                            R리터 초과일 때, 기본 요금 Q원 + R리터 초과량부터 1리터당 S원
- 함수
    - 입력 : 첫째줄 ~ 테스트 케이스 수 T
            둘째줄 ~ 각 테스트 케이스 별, 공백을 기준으로 P Q R S W
    - 제약 : 1 <= P,Q,R,S,W <= 10000, 모두 자연수
            최빈수가 여러개일때는 가장 큰 점수 출력
    - 출력 : 테스트케이스만큼의 라인에 각 테케 번호와 더 저렴한 회사의 측정 요금
- 손코딩
    테스트 케이스 수를 입력받는다.
    테스트 케이스 수만큼 반복문을 돌면서
        P, Q, R, S, W를 입력받는다. 
        A의 요금을 구한다. W * P
        B의 요금을 구한다. W <= R일때 Q, W > R일 때 (W - R) * S + Q
        테케별 결과에 A사와 B사 요금 중 더 작은 것을 넣는다.
    테스트 케이스 수만큼 반복하면서
        각 테스트케이스 번호와 측정 요금을 출력한다.
*/
import java.util.Scanner;

public class WaterChargeCompetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();       // 총 테케 수
        int[] results = new int[T+1];   // 테케별 최빈수
        int P, Q, R, S, W;
        int afee, bfee;
         
        for(int t = 1; t <= T; t++) {
            P = sc.nextInt();
            Q = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            W = sc.nextInt();
             
            afee = W * P;
            if(W <= R) {
                bfee = Q;
            } else {
                bfee = Q + (W - R) * S;
            }
             
            results[t] = Math.min(afee, bfee);
        }
         
        for (int k = 1; k <= T; k++) {
            System.out.printf("#%d %d%n", k, results[k]);
        }
        sc.close();
    }
}
