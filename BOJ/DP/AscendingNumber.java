/* 11057. 오르막 수
- 요구사항 : 수의 길이가 주어졌을 때 자리가 오름차순을 이루는 수의 개수를 구해라
- 함수 
    - input : 수의 길이 N
    - restriction : 1 <= N <= 1000
                    수는 0으로 시작 가능
    - output : 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지
- 점화식 
    dp[N][i] = dp[N-1][i] + ... + dp[N-1][9]
- 쉬운 계단수랑 비슷했고 점화식도 구하기 쉬웠다.
- 3중 for문을 쓰기 싫었지만 다른 답을 봐도 썼길래 그냥 썼다.
- 마지막에서만 % 10007을 쓰면 안되고 각 dp를 구한 후에도 % 10007를 해줘야 하는데, 그 이유는 모르겠다.
*/

package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AscendingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n+1][10];
        int sum = 0;
        
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        for(int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        System.out.println(sum % 10007);
    }
}
