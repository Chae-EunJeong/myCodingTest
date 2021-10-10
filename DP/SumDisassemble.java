/* 2225. 합분해
- 요구사항 : 0부터 N까지의 수 중 K개를 더해 그 합이 N이 되는 경우의 수를 구해라
- 함수 
    - input : 두 정수 n, k
    - restriction : 1 <= n <= 200
                    1 <= k <= 200
                    덧셈의 순서가 바뀐 경우는 다른 경우(1+2 != 2+1)
                    한개의 수 여러번 사용 가능
    - output : 답을 1,000,000,000으로 나눈 나머지
- 점화식 
  - dp[1][1] = 1, dp[1][2] = 2, dp[1][3] = 3
  - dp[2][1] = 1, dp[2][2] = 3, dp[2][3] = 6
  - dp[3][1] = 1, dp[3][2] = 4, dp[3][3] = 10
  - 따라서 점화식은 dp[n][k] = dp[n-1][k] + dp[n][k-1]이다.
- 10억을 나눈 수를 출력할 때는 dp에 저장할 때 나머지 계산이 이뤄진 후 저장되어야 한다.
    - 출력할 때 뒤늦게 나누면 안됨
*/

package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumDisassemble {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inp = br.readLine();
        String[] tokens = inp.split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        int dp[][] = new int[n+1][k+1];

        for(int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        for(int i = 1; i <= k; i++) {
            dp[1][i] = i;
        }
        for(int j = 2; j <= n; j++) {
            for(int l = 2; l <= k; l++) {
                dp[j][l] = (dp[j][l-1] + dp[j-1][l]) % 1000000000;
            }
        }
        System.out.println(dp[n][k]);
    }
}
