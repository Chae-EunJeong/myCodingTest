/* 2133. 타일 채우기
- 요구사항 : 3 X N의 벽을 2 X 1, 1 X 2 크기의 타일로 채우는 경우의 수를 구해라.
- 함수 
    - input : 자연수 N 
    - restriction : 1 <= N <= 31
    - output : 경우의 수 (정수)
- 점화식 
    - d[n] = 3 * d[n-2] + (dp[n-4] + dp[n-6] + ... + dp[n-n]) * 2
        - d[4]일 때, d[2] * d[2]인 경우(3*3)와 d[4]일 때만 나오는 특수한 경우(2/2로 나뉜 부분이 1*2블록일 때)의 두 가지를 합쳐 11가지이다.
        - d[6]일 때, d[4] * d[2]인 경우(11*3)와 d[2] * d[4]에서 겹치지 않는 부분(d[4]에서 특수한 부분)을 더한 후 d[6]에서만 나오는 특수한 경우 2가지를 합쳐 41가지이다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FillingTiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];

        if(n % 2 != 0) {
            System.out.println(0);
            return ;
        }

        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4; i <= n; i += 2) {
            dp[i] = 3 * dp[i-2];
            for(int j = 4; j <= i; j += 2) {
                dp[i] += 2 * dp[i - j];
            }
        }
    
        
        System.out.println(dp[n]);
    }
}
