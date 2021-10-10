/* 10844. 쉬운 계단 수
- 요구사항 : 인접한 모든 자리수의 차이가 1이 나는 수를 계단 수라고 할 때, 수의 길이가 N인 계단 수의 총 개수를 구해라.
- 함수 
    - input : 자연수 N
    - restriction : 1 <= N <= 100
                    N은 자연수
    - output : 수의 길이가 N인 계단 수를 1,000,000,000으로 나눈 나머지 출력
- 2차원배열이 필요하다. dp[N][i]
    - N은 입력받은 수로, 자릿수를 나타낸다.
    - i는 N자리수에서 일의 자리의 수를 나타낸다.
- 끝자리가 i일 때, 가능한 앞자리수를 구하는 식으로 점화식을 찾는다.
    - 0일 때, 앞자리는 1만 가능
    - 1일 때, 앞자리는 0과 2 가능
    - 2일 때, 앞자리는 1과 3 가능
    ...
    - 9일 때, 앞자리는 8만 가능
- 점화식 
    - N자리수의 일의 자리가 0일 때, N-1자리수의 0+1 인경우의 수와 같다.
    - N자리수의 일의 자리가 9일 때, N-1자리수의 9-8인 경우의 수와 같다.
    - N자리수의 일의 자리가 1~8일 때, N-1자리수의 (1~8)-1과 (1~8)+1인 경우의 수의 합과 같다.
- 예를 들어,
    - N이 3일 때, _ _ 0 인 경우의 수를 구하려면 _ 1 0
                  _ _ 1 인 경우의 수를 구하려면 _ 0 1, _ 2 1
                  _ _ 2 인 경우의 수를 구하려면 _ 1 2, _ 3 2
                  _ _ 9 인 경우의 수를 구하려면 _ 8 9
*/


package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStairNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][10];
        long sum = 0;

        // 한자리 수 일 때는 모든 경우의 수가 하나뿐이다.
        for(int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                }
                else if(j == 9) {
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                }
                else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }
        
        for(int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % 1000000000);
    }
}
