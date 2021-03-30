/* 2579. 계단 오르기
- 요구사항 : 계단에 점수가 쓰여있고, 
            아래와 같은 규칙이 있을 때, 계단 맨 아래부터 도착점까지 가는 게임에서 얻을 수 있는 최대 점수를 구해라
    - 규칙 : 계단은 한 번에 한 계단 혹은 두 계단씩 오를 수 있다.
            연속 세 개의 계단을 모두 밟으면 안된다.
            마지막 도착점의 계단은 반드시 밟아야한다.
- 함수 
    - input : 첫번째줄에는 계단의 개수 n
              두번째줄부터 n+1번째줄까지 각 계단에 해당하는 점수
    - restriction : 1 <= n <= 300
                    1 <= 점수 <= 10,000
    - output : 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값 출력
- 점화식 
    - 마지막 계단을 반드시 밟아야하므로 OOX의 경우는 제외해야한다.
    - 앞앞의 계단은 밟지 않고 바로 앞 계단을 밟았을 때(XOO) : dp[i-3] + arr[i-1] + arr[i]
    - 앞앞의 계단을 밟고 바로 앞 계단을 밟지 않았을 때(OXO) : dp[i-2] + arr[i]
*/
package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Upstairs {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        int dp[] = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        //n이 1보다 크지 않은데 dp[2]에 값을 저장하면 런타임에러
        if(n > 1) {
            dp[2] = arr[1] + arr[2];
        }
        //i-2를 마시지 않는 경우와, i-1을 마시지 않는 경우 
        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
        }

        System.out.println(dp[n]);

        br.close();
    }
}
