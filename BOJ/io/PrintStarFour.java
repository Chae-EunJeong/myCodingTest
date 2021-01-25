/* 2441. 별 찍기 - 4
- 요구사항 : 정수 N을 입력받아 첫째줄에는 별 N개, N번째 줄에는 별 1개를 출력해라
- 함수
    - input : int N - 별 몇 개까지 출력할건지
    - restriction : 1 <= N <= 100
    - output : 첫째줄부터 N번째 줄까지 역순으로, 오른쪽정렬로 별 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStarFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            for(int j = n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        } 
    }
}
