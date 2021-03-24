/* 1912. 연속합
- 요구사항 : n개의 정수로 이루어진 임의의 수열에서 
            연속된 최소 하나 이상의 수를 선택해 구할 수 있는 합 중 가장 큰 합을 구해라
- 함수 
    - input : 첫번째줄에는 수열의 크기 n
              두번째줄에는 수열을 이루는 n개의 원소
    - restriction : 1 <= n <= 100,000
                    -1,000 <= 각 원소 <= 1,000
    - output : 가장 큰 합 출력
- 점화식
    - 이전 수 까지 더한 값에 현재 숫자를 더하는것과 안 더하는 것 중 더 큰게 dp 배열에 저장된다.
    - Math.max(dp[i-1] + arr[i], arr[i])
*/
package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContinuingSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pro = br.readLine().split(" ");
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int max = 0;

        for(int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(pro[i]);
        }
        
        dp[1] = arr[1];
        max = dp[1];

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
