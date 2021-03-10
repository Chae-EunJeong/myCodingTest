/* 9465. 스티커
- 요구사항 : 각 스티커에 점수가 매겨진 2행 n열짜리, 즉 2n짜리 스티커가 있을 때, 
            변을 공유하지 않는 스티커를 떼어 가능한 최대 점수를 구해라.
- 함수 
    - input : 테스트 케이스 t, t개의 {n열을 나타낼때의 n, 2행 n열의 스티커 점수} 
    - restriction : 1 <= N <= 100,000
                    N은 자연수
    - output : t개의 스티커 점수 최댓값
- 점화식 
  - 스티커의 변을 공유하는 바로 아래/위나 양옆은 뗄 수 없으므로, 대각선이나 대각선의 왼쪽과 고려해야한다.
  - (b)에서 예를들어 100을 떼려고 할 때는 왼쪽 대각선 아래의 50이나 왼쪽 대각선 아래의 왼쪽의 30 중 더 큰 점수를 얻을 수 있는 것을 뗀다.
  - 그게 한 스티커에서 떼어낼 수 있는 최대 경우의 수이다.
    - dp[0][k] = Math.max(dp[1][k-1] + arr[0][k], dp[1][k-2] + arr[0][k])
    - dp[1][k] = Math.max(dp[0][k-1] + arr[1][k], dp[0][k-2] + arr[1][k])
*/

package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sticker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n = 0;
        int arr_n[][];
        int dp[][];
        String row[];

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr_n = new int[2][n+1];
            dp = new int[2][n+1];
            for(int j = 0; j < 2; j++) {
                //엔터로 치기 전까지 입력받은 것을 공백으로 split(한 줄을 split)
                row =  br.readLine().split(" ");
                for(int k = 0; k < n; k++) {
                    arr_n[j][k] = Integer.parseInt(row[k]);
                }
            }
            dp[0][0] = arr_n[0][0];
            dp[1][0] = arr_n[1][0];
            dp[0][1] = arr_n[0][1] + dp[1][0];
            dp[1][1] = arr_n[1][1] + dp[0][0];

            for(int k = 2; k <= n; k++) {
                dp[0][k] = Math.max(dp[1][k-2], dp[1][k-1]) + arr_n[0][k];
                dp[1][k] = Math.max(dp[0][k-2], dp[0][k-1]) + arr_n[1][k];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
        br.close();
    }
}
