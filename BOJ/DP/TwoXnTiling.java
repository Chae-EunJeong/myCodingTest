/* 11726. 2 x n 타일링
- 요구사항 : 2xn 크기의 직사각형을 1x2, 2x1타일로 채우는 방법의 수를 구해라
- 함수 
    - input : 자연수 N
    - restriction : 1 <= N <= 1000
                    N은 자연수
    - output : 2xn 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지
- 점화식 : dp[n] = dp[n-1] + dp[n-2]
- Top-down
    - dp[n] = (tiling(n-1) + tiling(n-2)) % 10007
*/

package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoXnTiling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
