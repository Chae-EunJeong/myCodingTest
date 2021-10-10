/* 9095. 1,2,3 더하기
- 요구사항 : 주어지는 숫자를 1, 2, 3의 합으로 나타낼 수 있는 방법의 수를 구해라
- 함수 
    - input : 자연수 T, T개의 N
    - restriction : 1 <= N < 11
                    N은 자연수
    - output : 각 test case마다 N을 1,2,3의 합으로 나타낼 수 있는 방법의 수 출력
- 점화식 : dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
    - n은 (n-1) + 1, (n-2) + 2, (n-3) + 3으로 표현할 수 있다.
- 입력받기전에 점화식으로 배열 다 채워넣고 해당 n에 대한 배열값만 출력하는 게 깔끔하다.
- BufferedReader로 여러개 입력 받는게 헷갈렸다. StringTokenizer를 써야하나 하고.
*/

package BOJ.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfOneTwoThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNumber = Integer.parseInt(br.readLine());
        int n = 0;
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 0; i < testCaseNumber; i++) {
            n = Integer.parseInt(br.readLine());
            for(int j = 3; j <= 10; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[n]);
        }
    }
}
