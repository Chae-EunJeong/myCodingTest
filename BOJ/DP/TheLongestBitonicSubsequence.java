/* 11054. 가장 긴 바이토닉 부분 수열
- 요구사항 : 무작위로 숫자가 배치된 수열이 주어졌을 때 가장 긴 감소하는 부분 수열을 구해라
- 함수 
    - input : 1번째 줄에는 수열의 크기 n
              2번째줄 ~ n+1줄에는 수열을 이루는 원소 i
    - restriction : 1 <= n <= 1,000
                    1 <= i <= 1,000
    - output : 주어진 수열에서 가장 긴 증가하는 부분 수열의 길이 출력
- 점화식 
    - arr[j] > arr[i] && dp[j] >= dp[i]
*/
package BOJ.DP;

public class TheLongestBitonicSubsequence {
    
}
