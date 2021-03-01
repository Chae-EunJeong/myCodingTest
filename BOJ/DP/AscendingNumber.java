/* 11057. 오르막 수
- 요구사항 : 
- 함수 
    - input : 
    - restriction :
    - output : 
- 점화식 
    
*/

package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AscendingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long dp[][] = new long[n+1][10];
        int sum = 0;
        
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                dp[i][j] += dp[i-1][j];
            }
        }

        for(int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
    }
}
