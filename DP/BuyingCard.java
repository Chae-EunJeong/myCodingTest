/* 11052. 카드 구매하기
- 요구사항 : 카드팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 지불해야하는 금액의 최대값을 구해라
- 함수
  - 입력 : 구매하려는 카드의 개수 N(int)
           카드팩의 가격 순서대로(Pi)
  - 제약 : 1 <= N <= 1,000
          1 <= Pi <= 10,000
  - 출력 : 카드 N개를 갖기 위해 지불해야하는 최대 금액
- 점화식
  - dp[4]는 p[4], dp[3] + p[1], dp[2] + p[2], dp[3] + p[1] 중에 최댓값
  - dp[i] = dp[i - j] + p[j]
*/

//package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuyingCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ps = br.readLine().split(" ");
        int[] p_arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 0; i < n; i++) {
            p_arr[i+1] = Integer.parseInt(ps[i]);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(dp[i] <= dp[i-j] + p_arr[j]) {
                    dp[i] = dp[i-j] + p_arr[j];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
