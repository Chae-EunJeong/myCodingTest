/* 1463. 1로 만들기
- 요구사항 : 정수 N를 입력받은 후, 세 가지 연산을 최소로 사용해 1로 만들어라.
    - 1. N이 3으로 나누어 떨어지면 3으로 나눈다.
    - 2. N이 2로 나누어 떨어지면 2로 나눈다.
    - 3. 1을 뺀다.
- 함수 
    - input : 자연수 N
    - restriction : 1 <= N <= 10^6
                    N은 자연수
    - output : 연산 횟수의 최솟값
- Dynamic Programming(DP) : issue#7에 정리
- 점화식 : f(N) = min(f(N-1),f(N/2),f(N/3))+1
- Bottom-up 방식
    - N을 1로 만드는 최소 횟수는 N-1 || N/2 || N/3을 1로 만드는 최소 횟수 + 1이다.
    - 저 셋 중 제일 작은 것 + 1이 N을 1로 만드는 최소 횟수
- Recursive 방식
    - Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)))
    - 나머지 값은 -1했을 때의 count 값과 같다.
*/

package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeIntoOne {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp =new int[n+1];
        dp[0] = dp[1] = 0;
        

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]); 
        br.close();
    }
}