/* 10991. 별 찍기 - 16
- 요구사항 : 정수 N을 입력받아 첫째줄에는 별 1개, N번째 줄에는 별 N개 트리모양을 출력해라
- 함수
    - input : int N - 별을 몇째줄까지 출력할건지
    - restriction : 1 <= N <= 100
    - output : 첫째줄부터 N번째 줄까지, 각 별 사이에는 공백이 하나씩 들어가는 별트리 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStarSixteen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            sb.append(" ".repeat(n-i));
            sb.append("* ".repeat(i));
            sb.append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}
