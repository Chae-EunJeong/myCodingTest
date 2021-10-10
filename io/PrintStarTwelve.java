/* 2522. 별 찍기 - 12
- 요구사항 : 정수 N을 입력받아 첫째줄에는 별 1개 , N번째 줄에는 별 N개, 2*N-1번째 줄에는 다시 별 1개로 되는 오른쪽 정렬 모양을 출력해라
- 함수
    - input : int N - 별 몇 개까지 출력할건지
    - restriction : 1 <= N <= 100
    - output : 첫째줄부터 2*N-1번째 줄까지 차례로, 오른쪽 정렬, 반절짜리 리본 모양으로 별 출력
- 별 찍기 - 8에 comment 한 것 처럼 repeat을 썼고, Stringbuilder로 append해봤다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStarTwelve { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int line = 2 * n - 1;

        for(int i = 1; i <= line; i++) {
            if(i <= n) {
                sb.append(" ".repeat(n-i));
                sb.append("*".repeat(i));
                sb.append("\n");
            }
            else {
                sb.append(" ".repeat(i-n));
                sb.append("*".repeat(n-(i-n)));
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    
}
