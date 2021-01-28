/* 10992. 별 찍기 - 17
- 요구사항 : 정수 N을 입력받아 첫째줄에는 별 1개, N번째 줄에는 별 N개 트리모양을 출력해라
- 함수
    - input : int N - 별을 몇째줄까지 출력할건지
    - restriction : 1 <= N <= 100
    - output : 첫째줄부터 N번째 줄까지, 
                첫째줄과 N째줄을 제외한 라인에서는 가장자리 별을 제외하고 공백으로 채운 별트리 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStarSeventeen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            sb.append(" ".repeat(n-i));
            if(i > 1 && i < n) {
                sb.append("*");
                sb.append(" ".repeat(2*i-3));
                sb.append("*\n");
            }
            else {
                sb.append("*".repeat(2*i-1));
                sb.append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}
