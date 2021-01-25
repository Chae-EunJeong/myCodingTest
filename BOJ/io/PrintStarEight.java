/* 2445. 별 찍기 - 8
- 요구사항 : 정수 N을 입력받아 첫째줄에는 별 1개 대칭, N번째 줄에는 별 N개 대칭, 2*N-1번째 줄에는 다시 별 1개 대칭으로 되는 리본 모양을 출력해라
- 함수
    - input : int N - 별 몇 개까지 출력할건지
    - restriction : 1 <= N <= 100
    - output : 첫째줄부터 2*N-1번째 줄까지 차례로, 가운데 대칭, 리본 모양으로 별 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStarEight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 2*n-1; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for(int j = 2*(n-i); j > 0; j--) {
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        } 
    }
}
