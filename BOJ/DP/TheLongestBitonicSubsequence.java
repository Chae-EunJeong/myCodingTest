/* 11054. 가장 긴 바이토닉 부분 수열
- 요구사항 : 무작위로 숫자가 배치된 수열이 주어졌을 때 가장 긴 바이토닉 부분 수열을 구해라
    - 바이토닉 수열 : 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족하는 수열
                    수 하나를 기준으로 그 수까지는 커졌다가 그 수 이후로는 작아지는 수열
- 함수 
    - input : 첫번째줄에는 수열의 크기 n
              두번째줄에는 수열을 이루는 n개의 원소
    - restriction : 1 <= n <= 1,000
                    1 <= 각 원소 <= 1,000
    - output : 주어진 수열에서 가장 긴 바이토닉 부분 수열의 길이 출력
- 점화식 
    - 증가수열을 계산한 tempA
        - if(arr[j] < arr[i] && tempA[i] <= tempA[j]) 
    - 감소수열을 계산한 tempB
        - if(arr[j] < arr[i] && tempB[i] <= tempB[j])
    - 합한 dp
        - dp[i] = dp[i] + tempA[i] + tempB[i];
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheLongestBitonicSubsequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pro = br.readLine().split(" ");
        int arr[] = new int[n+1];
        //찾아야할 dp배열과, 
        //증가수열의 dp배열인 tempA, 감소수열의 dp배열인 tempB을 선언한다.
        int dp[] = new int[n+1];
        int tempA[] = new int[n+1];
        int tempB[] = new int[n+1];
        int max = 0;

        //dp배열은 최소 수열의 길이를 뜻하는 1로 초기화
        //tempA와 tempB는 자기 자신 이외의 수열 길이만 세기 위해 0으로 초기화
        for(int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(pro[i]);
            dp[i+1] = 1;
            tempA[i+1] = 0;
            tempB[i+1] = 0;
        }

        //증가수열을 위해 처음부터 배열을 돌면서 이중 for문
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(arr[j] < arr[i] && tempA[i] <= tempA[j]) {
                    tempA[i] = tempA[j] + 1;
                }
            }
        }

        //감소수열을 위해 뒤에서부터 배열을 돌면서 이중 for문
        for(int i = n - 1; i > 0; i--) {
            for(int j = n; j > i; j--) {
                if(arr[j] < arr[i] && tempB[i] <= tempB[j]) {
                    tempB[i] = tempB[j] + 1;
                }
            }
        }

        //tempA와 tempB를 더하고 자기 길이인 1을 더한 dp 계산 후 가장 큰 숫자 찾기
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i] + tempA[i] + tempB[i];
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        
        System.out.println(max);
        br.close();
    }
}
