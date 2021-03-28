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
*/

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
        br.close();
    }
}
