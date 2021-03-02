/* 2193. 이친수
- 요구사항 : N을 입력받아 N자리 이친수(0으로 시작하지 않고 1이 두 번 연속 나타나지 않는 이진수)의 개수를 구해라
- 함수 
    - input : 자연수 N
    - restriction : 1 <= N <= 90
                    N은 자연수
    - output : N자리 이친수의 개수
- 점화식 
    - 일차원배열 : 피보나치수열. dp[n] = dp[n-1] + dp[n-2]
    - 이차원배열 : dp[n][0] = dp[n-1][0] + dp[n-1][1]
                  dp[n][1] = dp[n-1][0]
*/

package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*long dp[][] = new long[n+1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 2; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j+1];
                }
                else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        
        System.out.println(dp[n][0] + dp[n][1]);*/
        long dp[] = new long[91];
        dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
