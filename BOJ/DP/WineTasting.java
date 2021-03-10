/* 2156. 포도주 시식
- 요구사항 : n개의 포도주 잔에 순서대로 양이 주어져있을 때, 조건에 맞게 가장 많이 먹을 수 있는 포도주의 양을 구해라.
- 함수 
    - input : 1번째 줄에는 포도주 잔의 개수 n
              2번째줄 ~ n+1줄에는 각 포도주의 양
    - restriction : 1 <= n <= 10,000
                    0 <= 포도주의 양 <= 1,000
                    연속으로 놓여있는 포도주 3잔을 모두 마실 수는 없음(최대 연속 두 잔)
    - output : 최대로 마실 수 있는 포도주의 양
- 점화식 
  
*/

package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WineTasting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        int dp[] = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if(n > 1) {
            dp[2] = arr[2] + arr[1];
        }

        for(int j = 3; j <= n; j++) {
            dp[j] = Math.max(dp[j-1], Math.max(dp[j-3] + arr[j-1] + arr[j], dp[j-2] + arr[j]));
        
        }

        System.out.println(dp[n]);
        br.close();
    }
}
