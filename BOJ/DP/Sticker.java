/* 9465. 스티커
- 요구사항 : 각 스티커에 점수가 매겨진 2행 n열짜리, 즉 2n짜리 스티커가 있을 때, 
            변을 공유하지 않는 스티커를 떼어 가능한 최대 점수를 구해라.
- 함수 
    - input : 테스트 케이스 t, t개의 {n열을 나타낼때의 n, 2행 n열의 스티커 점수} 
    - restriction : 1 <= N <= 100,000
                    N은 자연수
    - output : t개의 스티커 점수 최댓값
- 점화식 
    -
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
        }

    }
}
