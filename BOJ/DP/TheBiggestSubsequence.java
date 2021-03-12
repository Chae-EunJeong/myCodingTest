/* 11055. 가장 큰 증가하는 부분 수열
- 요구사항 : 무작위로 숫자가 배치된 수열이 주어졌을 때,
            그 수열의 증가 부분 수열 중에서 가장 큰 합이 될 수 있는 수를 출력해라
- 함수 
    - input : 1번째 줄에는 수열의 크기 n
              2번째줄 ~ n+1줄에는 수열을 이루는 원소 i
    - restriction : 1 <= n <= 1,000
                    1 <= i <= 1,000
    - output : 주어진 수열에서 가장 긴 증가하는 부분 수열의 합 출력
- 점화식 
  
*/

package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheBiggestSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //공백을 기준으로 숫자 하나씩 나누기
        String[] pro = br.readLine().split(" ");

        int arr[] = new int[n+1];
        int dp[] = new int[n+1];
        int max = 0;
        //문자열로 받은 수열의 원소들을 int로 변환
        for(int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(pro[i]);
            dp[i+1] = arr[i+1];
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = arr[i] + dp[j];
                }
            }
        }

        for(int k = 1; k <= n; k++) {
            if(dp[k] > max) {
                max = dp[k];
            }
        }
        
        System.out.println(max);
    }
}
