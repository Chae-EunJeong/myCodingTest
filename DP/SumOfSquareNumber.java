/* 1699. 제곱수의 합
- 요구사항 : 자연수 N을 N보다 작거나 같은 제곱수들의 합으로 나타냈을 때, 
            표현할 수 있는 제곱수 합의 최소 개수를 구해라
    - 예 : 11 = 3^2 + 1^2 + 1^2 = 2^2 + 2^2 + 1^2 + 1^2 + 1^2 
        => 최소 3개의 항으로 표현할 수 있으므로 답은 3이다.
- 함수 
    - input : 자연수 N
    - restriction : 1 <= N <= 100,000
    - output : 표현 가능한 제곱수 합의 최소 개수
- 점화식 
    - n-(i)^2 >= 0인 범위 내에서
        - dp[n-(i)^2] + 1이 가장 작은 수
*/

//package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSquareNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];
        int min = 0; 

        for(int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; i - (j * j) >= 0; j++) {
                if(dp[i - (j * j)] + 1 < dp[i]) {
                    dp[i] = dp[i - (j * j)] + 1;
                }
            }
        }
        System.out.println(dp[n]);

        br.close();
    }
}
