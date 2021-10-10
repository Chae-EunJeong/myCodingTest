/* 9461. 파도반 수열
- 요구사항 : 삼각형이 나선 모양으로 놓여져있고, 변의 길이가 1인 첫 삼각형에서 시작해,
            나선에서 가장 긴 변의 길이 k를 변의 길이로 하는 정삼각형을 추가한다.
            나선에 있는 정삼각형의 변의 길이 P(N)을 구해라.
- 함수 
    - input : 테스트 케이스 개수 N 
    - restriction : 1 <= N <= 100
                    변의 길이가 점점 길어지고, int배열에 담기에 숫자가 엄청 커지므로 long 배열을 사용해야한다.
    - output : 각 테스트 케이스에 해당하는 P(N)
- 점화식 
    - P(1) = 1, P(2) = 1, P(3) = 1, P(4) = 2, P(5) = 2, P(6) = 3, P(7) = 4, P(8) = 5, P(9) = 7, P(10) = 9 이다.
    - n >= 6 이상일 때 부터 점화식 : dp[n] = dp[n-1] + dp[n-5]
    - dp[n] = dp[n-2] + dp[n-3] 도 만족한다.     
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadovanSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[101];
        int each = 0;

        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for(int i = 0; i < n; i++) {
            each = Integer.parseInt(br.readLine());
            for(int j = 6; j <= each; j++) {
                dp[j] = dp[j - 1] + dp[j - 5];
            }
            System.out.println(dp[each]);
        }

    }
}
