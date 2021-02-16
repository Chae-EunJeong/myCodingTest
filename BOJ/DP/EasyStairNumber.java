/* 10844. 쉬운 계단 수
- 요구사항 : 인접한 모든 자리수의 차이가 1이 나는 수를 계단 수라고 할 때, 수의 길이가 N인 계단 수의 총 개수를 구해라.
- 함수 
    - input : 자연수 N
    - restriction : 1 <= N <= 100
                    N은 자연수
    - output : 수의 길이가 N인 계단 수를 1,000,000,000으로 나눈 나머지 출력
- 2차원배열이 필요하다.
- 점화식 : 
*/


package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStairNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 5;
        dp[1] = 9;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = 2 * dp[i-1] - 1;
        }
        System.out.println(dp[n]);
    }
}
